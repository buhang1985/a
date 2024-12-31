package iih.bd.pp.hpsrvorca.s.impt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.RsHandler;

public class BdHpSrvorcaImportServiceImpl extends BDBaseDataImport<HPSrvorcaDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new HPSrvorcaDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { HPSrvorcaDO.ID_HPSRVORCA, HPSrvorcaDO.CODE, HPSrvorcaDO.ID_HPSRVTP,
				HPSrvorcaDO.SD_HPSRVTP, HPSrvorcaDO.ID_HP, HPSrvorcaDO.ID_GRP, HPSrvorcaDO.ID_ORG };
	}

	@Override
	protected void insertToDB(HPSrvorcaDO[] importDatas) throws BizException {
		ServiceFinder.find(IHpsrvorcaCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(HPSrvorcaDO[] importDatas) throws BizException {
		ServiceFinder.find(IHpsrvorcaCudService.class).update(importDatas);
	}

	@Override
	protected void checkImportData(HPSrvorcaDO[] importDatas) throws BizException {
		super.checkImportData(importDatas);
		verifyHpSrvorcaDo(importDatas);
	}

	private void verifyHpSrvorcaDo(HPSrvorcaDO[] hPSrvorcaDOs) throws BizException {
		final FMap mapMed = new FMap();
		final FMap mapDrug = new FMap();
		StringBuilder sbMed = new StringBuilder();
		sbMed.append(" SELECT ID_SRV,CODE FROM BD_SRV WHERE 1=1 AND DS=0");
		DAFacade facade = new DAFacade();
		facade.execQuery(sbMed.toString(), new RsHandler() {
			@Override
			public Object handleRs(ResultSet var1) throws SQLException {
				while (var1.next()) {
					mapMed.put(var1.getString(2), var1.getString(1));
				}
				return null;
			}
		});

		StringBuilder sbDrug = new StringBuilder();
		sbDrug.append(" SELECT ID_MM,CODE,ID_SRV FROM BD_MM WHERE 1=1");
		facade.execQuery(sbDrug.toString(), new RsHandler() {

			@Override
			public Object handleRs(ResultSet var1) throws SQLException {
				while (var1.next()) {
					mapDrug.put(var1.getString(2), var1.getString(1) + "-" + var1.getString(3));
				}
				return null;
			}
		});
		List<String> errMsgLst = new ArrayList<String>();
		for (int i = 0; i < hPSrvorcaDOs.length; i++) {
			// 药品，这里数据做特殊处理，从医保对照里拿到的医疗类别和iih本身存储的有差别
			if (1 == hPSrvorcaDOs[i].getEu_hpsrvtp()) {
				boolean isDrug = true;
				Object drugCode = mapDrug.get(hPSrvorcaDOs[i].getHis_code());
				if (drugCode == null) {
					drugCode = mapMed.get(hPSrvorcaDOs[i].getHis_code());
					isDrug = false;
					if (drugCode == null) {
						errMsgLst.add(String.format("未找到物品编码为%s的物品，请确认数据是否存在!", hPSrvorcaDOs[i].getHis_code()));
						continue;
					}
				}
				if (isDrug)// 如果是药品
				{
					String strIdMM = ((String) drugCode).split("-")[0];
					String strIdSrv = ((String) drugCode).split("-")[1];
					hPSrvorcaDOs[i].setId_mm(strIdMM);
					hPSrvorcaDOs[i].setId_srv(strIdSrv);
				} else {
					hPSrvorcaDOs[i].setId_srv((String) drugCode);
				}
			} else {
				boolean isMed = true;
				Object medCode = mapMed.get(hPSrvorcaDOs[i].getHis_code());
				if (medCode == null) {
					medCode = mapDrug.get(hPSrvorcaDOs[i].getHis_code());
					isMed = false;
					if (medCode == null) {
						errMsgLst.add(String.format("未找到his编码为%s的服务项目，请确认数据是否存在!", hPSrvorcaDOs[i].getHis_code()));
						continue;
					}
				}
				if (isMed) {
					hPSrvorcaDOs[i].setId_srv((String) medCode);
				} else {
					String strIdMM = ((String) medCode).split("-")[0];
					String strIdSrv = ((String) medCode).split("-")[1];
					hPSrvorcaDOs[i].setId_mm(strIdMM);
					hPSrvorcaDOs[i].setId_srv(strIdSrv);
				}
			}
		}
		if (!ListUtil.isEmpty(errMsgLst)) {
			StringBuilder strErrMsg = new StringBuilder();
			for (String var1 : errMsgLst) {
				strErrMsg.append(var1).append("\r\n");
			}
			throw new BizException(strErrMsg.toString());
		}

	}
}
