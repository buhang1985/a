package iih.ei.itf.eiitfcate.s.bp;

import iih.ei.itf.md2.export.FileFactory;
import xap.mw.core.data.BizException;

/**
 * 使用接口分类构建PDF文件
 * 
 * @author hao_wu 2019-10-30
 *
 */
public class BuildPDFFileByCateIdBp {
	public byte[] exec(String itfCateId) throws BizException {

		byte[] mdFile = getMdFile(itfCateId);
		byte[] bytes = FileFactory.producePdf(mdFile);
		return bytes;
	}

	private byte[] getMdFile(String itfCateId) throws BizException {
		BuildMDFileByCateIdBp bp = new BuildMDFileByCateIdBp();
		byte[] mdFile = bp.exec(itfCateId);
		return mdFile;
	}
}
