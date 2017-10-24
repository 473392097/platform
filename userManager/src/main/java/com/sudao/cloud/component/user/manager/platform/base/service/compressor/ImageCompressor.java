package com.sudao.cloud.component.user.manager.platform.base.service.compressor;

import com.sudao.cloud.component.user.manager.platform.base.service.image.ImageSize;

import java.io.File;
import java.io.IOException;


public interface ImageCompressor {

//	public abstract void compressImageToVague(File srcFile, File targetFile) throws IOException;
	
    public abstract void compressImage(File srcFile, File targetFile, ImageSize imageSize) throws IOException;
    
    public abstract void compressImage(File srcFile, File targetFile) throws IOException;

}