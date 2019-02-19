package org.vones.templates;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.Copy;

public class Templates implements Plugin<Project> {

    private static final String FROM = "%s/templates";
    private static final String INTO = "/Applications/Android Studio.app/Contents/plugins/android/lib/templates/other/.";

    @Override public void apply(Project project) {
        project.getTasks().create("copyTemplates", Copy.class, task -> {
            String from = String.format(FROM, project.getRootDir());
            task.from(from, t -> t.include("**/"));
            task.into(INTO);
            task.doLast(t -> {
                System.out.println("cp -af " + from + " " + INTO);
                System.out.println("Templates copied");
            });
        });
    }
}
