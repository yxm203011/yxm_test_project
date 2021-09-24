package core.io;

public interface ResourceLoader {

    String CLASS_PATH_URL_PREFIX = "classPath:";

    Resource getResource(String localhost);
}
