package stu.edu.vn.da_doctruyen.Cloudnary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryConfig {
    private final Cloudinary cloudinary;

    public CloudinaryConfig() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dsyeobmcl",
                "api_key", "427744994972929",
                "api_secret", "aO8ekmcwQ5-NpEv0KaF2YaAc_2g"
        ));
    }

    public Map uploadImage(File file) throws IOException {
        return cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
    }
}
