package action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import utils.ImageUtil;

public class CreateValidateCodeAction extends BaseAction {
	// output
	private InputStream imageStream;

	public String execute() {
		// 1.���ù����࣬������֤�뼰ͼƬ
		Map<String, BufferedImage> imageMap = ImageUtil.createImage();
		// 2.��imageMap��ȡ����֤�룬������session
		String imageCode = imageMap.keySet().iterator().next();
		session.put("imageCode", imageCode);
		// 3.��imageMap��ȡ��ͼƬ��תΪ������
		BufferedImage image = imageMap.get(imageCode);
		try {
			imageStream = ImageUtil.getInputStream(image);
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}

		return "success";
	}

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}

}
