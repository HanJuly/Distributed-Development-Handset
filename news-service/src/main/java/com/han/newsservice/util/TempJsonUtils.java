package com.han.newsservice.util;

import com.han.newsservice.controller.NewsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.io.*;
import java.util.List;

public class TempJsonUtils {
    private static final Logger NEWS_LOGGER = LoggerFactory.getLogger(NewsController.class);

    public static   <T> T fromFile(String path,Class<T> c){
        try {
            StringBuilder json = getStringBuilder(path);

            NEWS_LOGGER.info("Json string from file: \n"+json.toString());

            return GsonUtils.gsonToBean(json.toString().trim(),c);
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static   <T> List<T> listFromFile(String path, Class<T> c){
        try {
            StringBuilder json = getStringBuilder(path);

            NEWS_LOGGER.info("Json string from file: \n"+json.toString());

            return GsonUtils.gsonToList(json.toString().trim(),c);
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private static StringBuilder getStringBuilder(String path) throws IOException {
        FileInputStream file = new FileInputStream(path);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(file);
        byte[] buff = new byte[1024];
        StringBuilder json = new StringBuilder();
        while (bufferedInputStream.read(buff) != -1) {
            json.append(new String(buff));
        }
        return json;
    }

}
