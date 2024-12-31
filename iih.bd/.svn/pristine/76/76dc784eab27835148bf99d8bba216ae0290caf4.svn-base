package iih.bd.mm.materialnames.s.bp.queryer;

import java.util.ArrayList;

import iih.bd.srv.medsrv.d.MedSrvAliasDO;
import iih.bd.srv.medsrv.d.MedSrvCodeSetDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvAliasDORService;
import iih.bd.srv.medsrv.i.IMedSrvCodeSetDORService;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDOQryService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 医疗服务查询器
 * 
 * @author hao_wu
 *
 */
public class MedSrvQueryer {

	/**
	 * 根据数据管控查询医疗服务列表
	 * 
	 * @param whereStr
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public static MedSrvDO[] findMedSrv(String whereStr, String orderStr, FBoolean isLazy) throws BizException {
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] result = medsrvMDORService.find(whereStr, orderStr, isLazy);
		return result;
	}

	/**
	 * 获取分页查询结果的数据
	 * 
	 * @param medSrvPagingRtnData
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static MedSrvDO[] getPageData(PagingRtnData<MedSrvDO> medSrvPagingRtnData) {
		FArrayList dataList = medSrvPagingRtnData.getPageData();
		MedSrvDO[] medSrvDOs = (MedSrvDO[]) dataList.toArray(new MedSrvDO[0]);
		return medSrvDOs;
	}

	/**
	 * 根据服务列表查询药品属性
	 * 
	 * @param pageData
	 * @return
	 * @throws BizException
	 */
	public static MedSrvDrugDO[] findMedSrvDrugByIds(MedSrvDO[] pageData) throws BizException {
		String[] ids = getIds(pageData);
		IMedSrvDrugDORService medSrvDrugDORService = ServiceFinder.find(IMedSrvDrugDORService.class);
		MedSrvDrugDO[] medSrvDrugDOs = medSrvDrugDORService.findByAttrValStrings(MedSrvDrugDO.ID_SRV, ids);
		return medSrvDrugDOs;
	}

	/**
	 * 根据医疗服务id查询医疗服务药品信息
	 * 
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public static MedSrvDrugDO findMedSrvDrugBySrvId(String id) throws BizException {
		IMedSrvDrugDORService medSrvDrugDORService = ServiceFinder.find(IMedSrvDrugDORService.class);
		MedSrvDrugDO[] medSrvAliasDOs = medSrvDrugDORService.findByAttrValString(MedSrvDrugDO.ID_SRV, id);
		return (medSrvAliasDOs != null && medSrvAliasDOs.length >= 1) ? medSrvAliasDOs[0] : null;
	}

	/**
	 * 根据医疗服务id查询医疗服务别名集
	 * 
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public static MedSrvAliasDO[] findMedSrvAliasSetBySrvId(String id) throws BizException {
		IMedSrvAliasDORService medSrvAliasDORService = ServiceFinder.find(IMedSrvAliasDORService.class);
		MedSrvAliasDO[] medSrvAliasDOs = medSrvAliasDORService.findByAttrValString(MedSrvAliasDO.ID_SRV, id);
		return medSrvAliasDOs;
	}

	/**
	 * 根据医疗服务id查询医疗服务编码集
	 * 
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public static MedSrvCodeSetDO[] findMedSrvCodeSetBySrvId(String id) throws BizException {
		IMedSrvCodeSetDORService medSrvCodeSetDORService = ServiceFinder.find(IMedSrvCodeSetDORService.class);
		MedSrvCodeSetDO[] medSrvCodeSetDOs = medSrvCodeSetDORService.findByAttrValString(MedSrvCodeSetDO.ID_SRV, id);
		return medSrvCodeSetDOs;
	}

	/**
	 * 根据医疗服务id查询医疗服务主信息
	 * 
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public static MedSrvDO findMedSrvById(String id) throws BizException {
		IMedsrvMDOQryService medsrvMDOQryService = ServiceFinder.find(IMedsrvMDOQryService.class);
		MedSrvDO medSrvDO = medsrvMDOQryService.findById(id);
		return medSrvDO;
	}

	/**
	 * 获取数据列表主键列表
	 * 
	 * @param pageData
	 * @return
	 */
	private static String[] getIds(MedSrvDO[] pageData) {
		ArrayList<String> ids = new ArrayList<String>();
		for (MedSrvDO medSrvDO : pageData) {
			ids.add(medSrvDO.getId_srv());
		}
		return ids.toArray(new String[0]);
	}
}
