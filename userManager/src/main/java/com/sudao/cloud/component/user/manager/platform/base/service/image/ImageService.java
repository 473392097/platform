package com.sudao.cloud.component.user.manager.platform.base.service.image;

import com.sudao.cloud.component.user.manager.platform.base.core.Session;
import com.sudao.cloud.component.user.manager.platform.base.service.BaseService;

import java.io.IOException;
import java.io.InputStream;

public interface ImageService extends BaseService {

    InputStream read(String path) throws IOException;

    String save(String name, InputStream inputStream, Session session) throws IOException;
    
//    public String saveToVague(String name, InputStream inputStream, Session session) throws IOException;
    
    ImageSize getImageSize(String imageUri) throws IOException;
    
    String downloadImageFromUri(String imageUri, Session session);

}
