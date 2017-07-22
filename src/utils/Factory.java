package utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * ����ģʽ �������ӿں�ʵ�����Ӧ֮��Ĺ�ϵ
 * 
 * @author tang
 * 
 */
public class Factory {
	private static Properties props = new Properties();
	static {
		InputStream ips = null;
		/**
		 * ������ƣ����ڱ���Ķ����õ��������ClassLoader
		 */

		try {
			ClassLoader loader = Factory.class.getClassLoader();
			ips = loader.getResourceAsStream("utils/dao.properties");
			// ���ص��ļ�����
			props.load(ips);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ļ�����ʧ��");
		}
	}

	// ��ȡ�ļ�����
	public static String getValue(String key) {
		return props.getProperty(key);
	}

	// ��ʼ��������ķ���
	public static Object getInstance(String type) {
		Object obj = null;
		try {
			String classname = getValue(type);
			Class c = Class.forName(classname);
			obj = c.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

}
