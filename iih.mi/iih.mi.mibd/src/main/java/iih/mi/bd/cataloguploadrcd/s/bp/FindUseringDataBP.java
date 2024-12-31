package iih.mi.bd.cataloguploadrcd.s.bp;

import java.util.ArrayList;

import iih.mi.bd.cataloguploadrcd.d.MiCatalogUploadRcdDO;
import iih.mi.bd.cataloguploadrcd.s.bp.qry.FindUseringDataSql;
import iih.mi.bd.d.AdmStatusCompInfoDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 查询可用数据
 * Title: FindUseringDataBP.java
 * @author zhang.hw
 * @date 2019年5月16日  
 * @version 1.0
 */
public class FindUseringDataBP {

	public MiCatalogUploadRcdDO exec(String idHp, String miSrvTp) throws BizException{
		FindUseringDataSql datasql = new FindUseringDataSql(idHp,miSrvTp);
		DAFacade daFacade = new DAFacade();
		ArrayList<MiCatalogUploadRcdDO> miCatalogUploadRcdDOs = (ArrayList<MiCatalogUploadRcdDO>) daFacade.execQuery(
				datasql.getQrySQLStr(), datasql.getQryParameter(null), new BeanListHandler(MiCatalogUploadRcdDO.class));
		if(miCatalogUploadRcdDOs==null||miCatalogUploadRcdDOs.size()<=0){
			return null;
		}
		MiCatalogUploadRcdDO miCatalogUploadRcdDO = miCatalogUploadRcdDOs.get(0);
		return miCatalogUploadRcdDO;
	}
	
}
