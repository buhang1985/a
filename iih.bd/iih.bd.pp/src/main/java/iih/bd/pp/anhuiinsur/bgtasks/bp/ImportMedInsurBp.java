package iih.bd.pp.anhuiinsur.bgtasks.bp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import iih.bd.pp.anhuisrvorca.s.bp.FindHpDoByCodeBp;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import xap.mw.core.data.BizException;

/**
 * 导入医保目录数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ImportMedInsurBp {

	public void exec(String fileKey, String hpCode, Integer hpSrvTp) throws BizException {
		// InputStream fileStream = FileServerUtils.Download(fileKey, true);
		InputStream fileStream = null;
		try {
			fileStream = new FileInputStream("D:\\xap_std2\\client\\xapclient\\YBDLOAD\\YPML_19000101000100.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImportMedInsur(fileStream, hpCode, hpSrvTp);
	}

	/**
	 * 导入医保目录数据
	 * 
	 * @param fileStream
	 *            文件流
	 * @param hpCode
	 *            医保计划编码
	 * @param hpSrvTp
	 *            医保项目类型
	 * @throws BizException
	 */
	private void ImportMedInsur(InputStream fileStream, String hpCode, Integer hpSrvTp) throws BizException {
		FindHpDoByCodeBp bp = new FindHpDoByCodeBp();
		HPDO hpdo = bp.exec(hpCode);

		if (hpSrvTp.equals(HpSrvTpEnum.DRUG)) {
			ImportMedInsurDrug(fileStream, hpdo);
		} else if (hpSrvTp.equals(HpSrvTpEnum.ZL)) {
			ImportMedInsurZl(fileStream, hpdo);
		} else if (hpSrvTp.equals(HpSrvTpEnum.FWSS)) {
			ImportMedInsurFwss(fileStream, hpdo);
		}
	}

	/**
	 * 导入医保药品目录数据
	 * 
	 * @param fileStream
	 *            文件流
	 * @param hpdo
	 *            医保计划
	 * @throws BizException
	 */
	private void ImportMedInsurDrug(InputStream fileStream, HPDO hpdo) throws BizException {
		ImportMedInsurDrugBp bp = new ImportMedInsurDrugBp();
		bp.exec(fileStream, hpdo);
	}

	/**
	 * 导入医保诊疗目录数据
	 * 
	 * @param fileStream
	 *            文件流
	 * @param hpdo
	 *            医保计划
	 * @throws BizException
	 */
	private void ImportMedInsurZl(InputStream fileStream, HPDO hpdo) throws BizException {
		ImportMedInsurZlBp bp = new ImportMedInsurZlBp();
		bp.exec(fileStream, hpdo);
	}

	/**
	 * 导入医保服务设施目录数据
	 * 
	 * @param fileStream
	 *            文件流
	 * @param hpdo
	 *            医保计划
	 */
	private void ImportMedInsurFwss(InputStream fileStream, HPDO hpdo) throws BizException {
		ImportMedInsurFwssBp bp = new ImportMedInsurFwssBp();
		bp.exec(fileStream, hpdo);
	}
}
