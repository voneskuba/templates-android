package org.vones.templates;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.file.FileTree;
import org.gradle.api.tasks.Copy;

import java.io.ByteArrayOutputStream;

public class Templates implements Plugin<Project> {

    @Override public void apply(Project project) {
        project.getTasks().create("copyTemplates", Copy.class, task -> {
            String resources = getClass().getProtectionDomain().getCodeSource().getLocation().toExternalForm();
            FileTree from = project.zipTree(resources)
                    .matching(p -> p.include("templates/**"))
                    .getAsFileTree();

            System.out.println("From: " + from);

            task.from(from, t -> t.include("**/"));
            task.into(project.getBuildDir());

            String tmp = project.getBuildDir().getAbsolutePath() + "/templates";
            String build = project.getBuildDir().getAbsolutePath() + "/templates/.";

            task.doLast(t -> {
                ByteArrayOutputStream out = new ByteArrayOutputStream();

                project.exec(e -> {
                    e.commandLine(
                            "bash",
                            "-c",
                            "ps -ax | grep --only-matching '/[A-Za-z/]*/[Aa]ndroid[ -][Ss]tudio[ 0-9A-Za-z.]*/\\(Contents\\)\\?' | sort --unique"
                    );
                    e.setStandardOutput(out);
                });
                String lines[] = out.toString().split("[\\r\\n]+");

                System.out.println("Versions:");
                for (String line : lines) {
                    System.out.println(line);
                    project.exec(e -> e.commandLine(
                            "cp",
                            "-af",
                            build,
                            line + "/plugins/android/lib/templates/other/."
                    ));

                }
                project.exec(e -> e.commandLine(
                        "rm",
                        "-rf",
                        tmp
                ));
                System.out.println("Templates copied, restart Android Studio, please!");
            });
        });
    }

}
