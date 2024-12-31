package iih.bd.pp.anhuiinsur.bgtasks.bp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import iih.bd.pp.medinsursrvfacrec.d.MedInsurSrvFacRecDO;
import iih.bd.pp.medinsursrvfacrec.i.IMedinsursrvfacrecCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 导入医保服务设施业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ImportMedInsurFwssRecBp {

	// 缓冲区大小
	private final int _bufferSize = 10000;

	private final String[] _propNameMapping = new String[] { "Code", "Name", "Dt_b", "Code_ca", "Hospital_rank",
			"Hospital_bed_rank", "Fwss_pay_standard", "Pri_max", "Retire_ey_pri_max", "Py_code", "Wb_code", "Des",
			"Dt_e", "Id_emp_handle", "Dt_handle", "Str_effective" };

	public void exec(InputStream fileStream, MedInsurFileDownRecDO medInsurFileDownRec) throws BizException {
		SaveMedInsurSrvFac(fileStream, medInsurFileDownRec);
		GenerateDataDiff(medInsurFileDownRec);
	}

	/**
	 * 生成数据差异
	 * 
	 * @param medInsurFileDownRec
	 * @throws BizException
	 */
	private void GenerateDataDiff(MedInsurFileDownRecDO medInsurFileDownRec) throws BizException {
		StartGenerateDiffInfoByDownIdBp bp = new StartGenerateDiffInfoByDownIdBp();
		bp.exec(medInsurFileDownRec);
	}

	/**
	 * 反序列化并保存到数据库
	 * 
	 * @param fileStream
	 * @param hpdo
	 * @param medInsurFileDownRec
	 * @throws BizException
	 */
	private void SaveMedInsurSrvFac(InputStream fileStream, MedInsurFileDownRecDO medInsurFileDownRec)
			throws BizException {
		DeserializeBp<MedInsurSrvFacRecDO> bp = new DeserializeBp<MedInsurSrvFacRecDO>(this._propNameMapping);

		ArrayList<MedInsurSrvFacRecDO> dataList = new ArrayList<MedInsurSrvFacRecDO>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));
		try {
			String lineStr = reader.readLine();
			while (StringUtils.isNotEmpty(lineStr)) {
				MedInsurSrvFacRecDO newData = bp.exec(lineStr, MedInsurSrvFacRecDO.class);
				if (newData != null) {
					dataList.add(newData);
				}
				if (dataList.size() >= this._bufferSize) {
					// 达到缓冲区最大值时保存到数据库
					SaveMedInsurSrvFac(dataList, medInsurFileDownRec);
					dataList.clear();
				}
				lineStr = reader.readLine();
			}
			if (dataList.size() > 0) {
				SaveMedInsurSrvFac(dataList, medInsurFileDownRec);
				dataList.clear();
			}

		} catch (IOException e) {
			throw new BizException(e);
		}
	}

	/**
	 * 保存服务设施目录数据到数据库
	 * 
	 * @param dataList
	 * @param hpdo
	 * @param medInsurFileDownRec
	 * @throws BizException
	 */
	private void SaveMedInsurSrvFac(ArrayList<MedInsurSrvFacRecDO> dataList, MedInsurFileDownRecDO medInsurFileDownRec)
			throws BizException {
		MedInsurSrvFacRecDO[] medInsurSrvFacRecs = dataList.toArray(new MedInsurSrvFacRecDO[0]);
		// 初始化共通属性值
		InitCommProp(medInsurSrvFacRecs, medInsurFileDownRec);
		// 保存到数据库
		IMedinsursrvfacrecCudService medinsurSrvFacrecCudService = ServiceFinder
				.find(IMedinsursrvfacrecCudService.class);
		medinsurSrvFacrecCudService.insert(medInsurSrvFacRecs);
	}

	/**
	 * 初始化共通属性
	 * 
	 * @param result
	 * @param hpdo
	 * @param medInsurFileDownRec
	 */
	private void InitCommProp(MedInsurSrvFacRecDO[] result, MedInsurFileDownRecDO medInsurFileDownRec) {
		for (MedInsurSrvFacRecDO medInsurSrvFacRec : result) {
			medInsurSrvFacRec.setId_grp(Context.get().getGroupId());
			medInsurSrvFacRec.setId_org(Context.get().getOrgId());
			medInsurSrvFacRec.setId_down(medInsurFileDownRec.getId_down());
		}
	}
}
