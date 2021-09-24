package core.io;


import cn.hutool.core.lang.Assert;

import java.net.URL;

public class DefaultResourceLoader implements ResourceLoader{

    @Override
    public Resource getResource(String localhost) {
        Assert.notNull(localhost,"Location must not be null");
        if(localhost.startsWith(CLASS_PATH_URL_PREFIX)){
            return new ClassPathResource(localhost.substring(CLASS_PATH_URL_PREFIX.length()));
        }else{
            try{
                URL url = new URL(localhost);
                return new UrlResource(url);
            }catch(Exception e){
                return new FileSystemResource(localhost);
            }
        }
    }
}
