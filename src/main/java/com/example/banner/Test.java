package com.example.banner;

import org.springframework.boot.ImageBanner;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ClassUtils;

public class Test {

    public static void main(String[] args) {
        int count = 5;
        
        if (args != null && args.length > 0 && args[0] != null) {
            count = Integer.parseInt(args[0]);
        }
        
        ClassLoader defaultClassLoader = ClassUtils.getDefaultClassLoader();
        ResourceLoader resourceLoader = new DefaultResourceLoader(defaultClassLoader);
        Resource resource = resourceLoader.getResource("classpath:banner.gif");
        StandardEnvironment environment = new StandardEnvironment();
//        MutablePropertySources sources = environment.getPropertySources();
//        sources.addFirst(new SimpleCommandLinePropertySource(args));
        
        ImageBanner imageBanner = new ImageBanner(resource);
        
        for (int i = 0 ; i < count ; i++) {
            imageBanner.printBanner(environment, Test.class, System.out);
            
            if (i < count - 1) {
                System.out.print("\033[41A\r");
            }
        }
    }
}
