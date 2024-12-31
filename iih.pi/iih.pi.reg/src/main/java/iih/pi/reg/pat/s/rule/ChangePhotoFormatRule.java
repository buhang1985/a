package iih.pi.reg.pat.s.rule;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;

import iih.pi.params.PiParams;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.IRule;

/**
 * 修改患者照片格式
 * @author ly  2019/11/29
 *
 * @param <T>
 */
public class ChangePhotoFormatRule<T> implements IRule<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void process(T... datas) throws BizException {
		
		if (datas == null || datas.length <= 0) {
			return;
		}
		
		if(FBoolean.FALSE.equals(new PiParams().PIPAT0030()))
			return;

		for (T t : datas) {
			if (t instanceof PatiAggDO) {
				changePhotoFormat(((PatiAggDO) t).getParentDO());
			} else if (t instanceof PatDO) {
				changePhotoFormat((PatDO) t);
			}
		}
	}
	
	/**
	 * 更改图片格式
	 * @param patDO
	 * @throws BizException
	 */
	private void changePhotoFormat(PatDO patDO) throws BizException {
		
		if(patDO.getPhoto() == null || patDO.getPhoto().length == 0)
			return;
		
		ImageInputStream inStream = null;
		ImageOutputStream outStream = null;
		ByteArrayOutputStream byteStream = null;
		
		try {
			inStream = new MemoryCacheImageInputStream(new ByteArrayInputStream(patDO.getPhoto()));
			Iterator<ImageReader> iter = ImageIO.getImageReaders(inStream);
			ImageReader reader = iter.next();
			
			if("bmp".equals(reader.getFormatName())){
				
				byteStream = new ByteArrayOutputStream();
				outStream = new MemoryCacheImageOutputStream(byteStream);
				reader.setInput(inStream);
				
				ImageWriter bmpWriter = null;
				Iterator<ImageWriter> it2 = ImageIO.getImageWritersByFormatName("jpeg");
				if (it2.hasNext()) {
					bmpWriter = it2.next();
				}
				bmpWriter.setOutput(outStream);
				BufferedImage br = reader.read(0);
				bmpWriter.write(br);

				patDO.setPhoto(byteStream.toByteArray());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(inStream != null)
					inStream.close();
			} catch (Exception e2) {
			}
			try {
				if(outStream != null)
					outStream.close();
			} catch (Exception e2) {
			}
			try {
				if(byteStream != null)
					byteStream.close();
			} catch (Exception e2) {
			}
		}
	}
}
