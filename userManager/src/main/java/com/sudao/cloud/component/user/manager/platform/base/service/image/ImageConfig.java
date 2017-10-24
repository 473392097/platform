package com.sudao.cloud.component.user.manager.platform.base.service.image;


import com.sudao.cloud.component.user.manager.platform.base.core.config.ConfigLoader;

import java.io.IOException;
import java.util.List;

public class ImageConfig {
    /**
     * format: 80x80
     */
    private List<String> imageSizes;
    
    /**
     * 图片压缩质量
     */
    private float imageQuality = 0.6f;

    public static synchronized ImageConfig load() throws IOException {
        return ConfigLoader.loadYamlAs("image.yaml", ImageConfig.class);
    }

    public List<String> getImageSizes() {
        return imageSizes;
    }

    public void setImageSizes(List<String> imageSizes) {
        this.imageSizes = imageSizes;
    }

    public float getImageQuality() {
        return imageQuality;
    }

    public void setImageQuality(float imageQuality) {
        this.imageQuality = imageQuality;
    }
}
