package org.vones.templates;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.Copy;
import org.gradle.internal.impldep.com.esotericsoftware.minlog.Log;

public class Templates implements Plugin<Project> {

    @Override public void apply(Project project) {
        project.getTasks().create("copyTemplates", Copy.class, t -> {
            t.doLast(task -> {
                Log.error("ERROR", "Test plugin");
            });
        });
    }
}


//open class Templates : Plugin<Project> {
//
//    private companion object {
//        const val FROM = "%s/templates"
//        const val INTO = "/Applications/Android Studio.app/Contents/plugins/android/lib/templates/other/."
//    }
//
//    override fun apply(project: Project) {
//        project.tasks.create("copyTemplates", Copy::class) {
//            val from = String.format(FROM, project.rootDir)
//            from(from) {
//                include("**/")
//        }
//        into(INTO)
//        doLast {
//        println("cp -af $from $INTO")
//        println("Templates copied")
//        }
//        }
//        }
//        }
// */
