import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.file.FileTree;
import org.gradle.api.tasks.Copy;

public class Templates implements Plugin<Project> {

    private static final String FROM = "%s/templates";
    private static final String INTO = "/Applications/Android Studio.app/Contents/plugins/android/lib/templates/other/.";

    private final ClassLoader loader = getClass().getClassLoader();

    @Override public void apply(Project project) {
        project.getTasks().create("copyTemplates", Copy.class, task -> {
            String resources = getClass().getProtectionDomain().getCodeSource().getLocation().toExternalForm();
            FileTree from = project.zipTree(resources)
                    .matching(p -> p.include("templates/**/"))
                    .getAsFileTree();

            System.out.println("from1  " + from);

            task.from(from, t -> t.include("**/"));
            task.into(project.getBuildDir());

            System.out.println("from2  " + project.getBuildDir() + "/templates/.");

            task.from(project.getBuildDir() + "/templates/.", t -> t.include("**/"));
            task.into(INTO);

            task.doLast(t -> {
                System.out.println("cp -af " + from + " " + INTO);
                System.out.println("Templates copied");
            });
        });
    }

}

//    getClass().classLoader.findResource("plugin-classpath.txt")

//    String resource =     getClass().getResource("/environments/development.properties").getFile();
//    File input = new File(resource);

//    getClass().getResource("/gui/dialogues/plugins/PluginSelection.fxml")
