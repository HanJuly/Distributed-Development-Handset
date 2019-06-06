package com.han.newsservice.util;

import com.han.newsservice.controller.NewsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.io.*;
import java.util.List;

public class TempJsonUtils {
    private static final Logger NEWS_LOGGER = LoggerFactory.getLogger(NewsController.class);

    public static   <T> T fromFile(String filePath,Class<T> c){
        try {
            StringBuilder json = getStringBuilder(filePath);

            NEWS_LOGGER.info("Json string from file: \n"+json.toString());

            return GsonUtils.gsonToBean(json.toString().trim(),c);
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static   <T> List<T> listFromFile(String filePath, Class<T> c){
        try {
            StringBuilder json = getStringBuilder(filePath);

            NEWS_LOGGER.info("Json string from file: \n"+json.toString());

            return GsonUtils.gsonToList(json.toString().trim(),c);
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private static StringBuilder getStringBuilder(String filePath) throws IOException {
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
             inputStream = TempJsonUtils.class.getResourceAsStream(filePath);
             bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] buff = new byte[1024];
            StringBuilder json = new StringBuilder();
            while (bufferedInputStream.read(buff) != -1) {
                json.append(new String(buff));
            }
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            if(bufferedInputStream != null){
                bufferedInputStream.close();
            }
            if(inputStream != null){
                inputStream.close();
            }
        }
        return null;
    }

}
