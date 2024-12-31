package iih.bd.pp.hp.bp;

import java.util.HashMap;
import java.util.Map;

import iih.bd.pp.hp.d.HPDO;
//import iih.bd.pp.hp.d.HpSrvOrCaDO;
import iih.bd.pp.hp.d.desc.HPDODesc;
import iih.bd.pp.hp.s.HpMDOCrudServiceImpl;
//import iih.bd.pp.hp.s.HpSrvOrCaDOCrudServiceImpl;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.desc.HPSrvorcaDODesc;
import iih.bd.pp.hpsrvorca.s.HpsrvorcaCrudServiceImpl;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.srv.srvcate.d.desc.SrvCateDODesc;
import iih.bd.srv.srvcate.i.ISrvcateMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.innercode.InnerCodeUtil;

/**
 * 获取服务在指定医保计划下的医保目录类型 具体实现
 * 
 * @author 刘 斌 2015年9月2日 下午3:46:40
 */
public class GetHpSrvTpBp {

	/**
	 * 获取服务在指定医保计划下的医保目录类型
	 * 
	 * @param hpCode
	 *            医保计划编码
	 * @param idSrv
	 *            服务项目id
	 * @return 医保计划对应的服务项目或者分类的DO
	 */
	public HPSrvorcaDO getHpSrvTpByCode(String hpCode, String idSrv)
			throws BizException {
		HPSrvorcaDO hpSrvOrCaDO = null;
		HPDO hpDO = this.getHpDOByCode(hpCode);
		if (hpDO != null) {
			hpSrvOrCaDO = getHpSrvTpById(hpDO.getId_hp(), idSrv);
		}
		return hpSrvOrCaDO;
	}

	/**
	 * 获取服务在指定医保计划下的医保目录类型
	 * 
	 * @param hpId
	 *            医保计划ID
	 * @param idSrv
	 *            服务项目id
	 * @return 医保计划对应的服务项目或者分类的DO
	 * @throws BizException
	 */
	public HPSrvorcaDO getHpSrvTpById(String hpId, String idSrv)
			throws BizException {

		// 1、查询对应的服务
		HPSrvorcaDO hpSrvOrCaDO = this.queryHpSrv(hpId, idSrv);
		if (hpSrvOrCaDO == null) {
			// 2 获取服务对应的服务分类InnerCode
			String innerCode = this.getSrvCaInnerCode(idSrv);
			if (innerCode != null) {
				// 通过InnerCode查询深度最深的服务分类
				SrvCateDO[] srvCateDOs = this.getSrvCasByInnerCode(innerCode);
				if (!ArrayUtil.isEmptyNoNull(srvCateDOs)) {
					hpSrvOrCaDO = this.getHpSrvTp(hpId, srvCateDOs);
				}
			}
		}
		return hpSrvOrCaDO;
	}
	
	public Map<String,HPSrvorcaDO> getHpSrvOrCaDOMap(String hpId,String[] arrIdSrv) throws BizException
	{
		//验证参数的合法性
		if(hpId==null || StringUtil.isEmptyWithTrim(hpId))
			throw new BizException("医保目录对照查询条件丢失，请提供待查询的医保计划");
		if(arrIdSrv==null || arrIdSrv.length<=0)
			throw new BizException("医保目录对照查询条件丢失，请提供待查询的服务项目");
		Map<String,HPSrvorcaDO> map=new HashMap<String,HPSrvorcaDO>();
		//组装sql语句
		String strWhereSql="";
		for(int i=0;i<arrIdSrv.length;i++)
		{
			strWhereSql+="'"+arrIdSrv[i]+"',";
		}
		strWhereSql=strWhereSql.substring(0, strWhereSql.length()-1);
		strWhereSql=String.format("%s.id_hp='%s' and %s.id_srv in (%s)",HPSrvorcaDODesc.TABLE_ALIAS_NAME,hpId,HPSrvorcaDODesc.TABLE_ALIAS_NAME,strWhereSql);
		HpsrvorcaCrudServiceImpl serviceImpl=new HpsrvorcaCrudServiceImpl();
		HPSrvorcaDO[] arrHpsrvorcado=serviceImpl.find(strWhereSql, null, FBoolean.FALSE);
		for(int m=0;m<arrHpsrvorcado.length;m++)
		{
			map.put(arrHpsrvorcado[m].getId_srv(), arrHpsrvorcado[m]);
		}
		return map;	
	}

	/**
	 * 通过医保Code获得医保计划
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private HPDO getHpDOByCode(String code) throws BizException {
		HPDO hpDO = null;
		String whereStr = String.format("%s.CODE='%s'", HPDODesc.TABLE_ALIAS_NAME, code);
		HpMDOCrudServiceImpl hpService = new HpMDOCrudServiceImpl();
		HPDO[] hpDOs = hpService.find(whereStr, null, FBoolean.FALSE);
		if (!ArrayUtil.isEmptyNoNull(null)) {
			hpDO = hpDOs[0];
		}
		return hpDO;
	}

	/**
	 * 获取医保计划对应的服务项目或者分类的DO
	 * 
	 * @param hpId
	 *            医保计划ID
	 * @param idSrv
	 *            服务项目id
	 * @return 医保计划对应的服务项目或者分类的DO
	 */
	private HPSrvorcaDO queryHpSrv(String hpId, String idSrv)
			throws BizException {
		HPSrvorcaDO hpSrvOrCaDO = null;
		String whereStr = String.format("%s.ID_HP='%s' AND %s.ID_SRV='%s'", HPSrvorcaDODesc.TABLE_ALIAS_NAME, hpId,HPSrvorcaDODesc.TABLE_ALIAS_NAME, idSrv);
		HpsrvorcaCrudServiceImpl srvOrCaService = new HpsrvorcaCrudServiceImpl();
		HPSrvorcaDO[] hpSrvOrCaDOs = srvOrCaService.find(whereStr, null,
				FBoolean.FALSE);
		if (!ArrayUtil.isEmptyNoNull(hpSrvOrCaDOs)) {
			hpSrvOrCaDO = hpSrvOrCaDOs[0];
		}
		return hpSrvOrCaDO;
	}

	/**
	 * 根据服务获取服务分类InnerCode
	 * 
	 * @param idSrv
	 * @return
	 * @throws BizException
	 */
	private String getSrvCaInnerCode(String idSrv) throws BizException {
		String InnerCode = null;
		IMedsrvMDORService srvService = ServiceFinder
				.find(IMedsrvMDORService.class);
		MedSrvDO medSrvDO = srvService.findById(idSrv);
		if (medSrvDO != null
				&& StringUtil.isEmptyWithTrim(medSrvDO.getId_srvca())) {
			ISrvcateMDORService srvCaService = ServiceFinder
					.find(ISrvcateMDORService.class);
			SrvCateDO srvCateDO = srvCaService.findById(medSrvDO.getId_srvca());
			if (srvCateDO != null) {
				InnerCode = srvCateDO.getInnercode();
			}
		}
		return InnerCode;
	}

	/**
	 * 通过InnerCode查询深度最深的服务分类
	 * 
	 * @param innerCode
	 * @return
	 * @throws BizException
	 */
	private SrvCateDO[] getSrvCasByInnerCode(String innerCode)
			throws BizException {
		String[] innerCodes = InnerCodeUtil.getSuppriorInnerCodes(innerCode);
		StringBuilder codeBuilder = new StringBuilder();
		for (int i = innerCodes.length - 1; i >= 0; i--) {
			codeBuilder.append("'").append(innerCodes[i]).append("'")
					.append(",");
		}
		String innerCodeStr = codeBuilder.deleteCharAt(
				codeBuilder.lastIndexOf(",")).toString();
		String whereStr = String.format("%s.INNERCODE IN (%s)", SrvCateDODesc.TABLE_ALIAS_NAME, innerCodeStr);
		ISrvcateMDORService srvCaService = ServiceFinder
				.find(ISrvcateMDORService.class);
		SrvCateDO[] srvCateDOs = srvCaService.find(whereStr, null,
				FBoolean.FALSE);
		return srvCateDOs;
	}

	/**
	 * 获取医保计划对应的服务项目或者分类的DO
	 * 
	 * @param hpId
	 *            医保计划ID
	 * @param srvCateDOs
	 *            服务项目分类集合
	 * @return 医保计划对应的服务项目或者分类的DO
	 */
	private HPSrvorcaDO getHpSrvTp(String hpId, SrvCateDO[] srvCateDOs)
			throws BizException {
		HPSrvorcaDO hpSrvOrCaDO = null;
		StringBuilder builder = new StringBuilder();
		for (SrvCateDO srvCateDO : srvCateDOs) {
			builder.append("'").append(srvCateDO.getId_srvca()).append("'")
					.append(",");
		}
		String srvCaStr = builder.deleteCharAt(builder.lastIndexOf(","))
				.toString();
		String whereStr = String.format("%s.ID_HP='%s' AND %s.ID_SRVCA IN (%s)",
				HPSrvorcaDODesc.TABLE_ALIAS_NAME, hpId,  HPSrvorcaDODesc.TABLE_ALIAS_NAME,srvCaStr);
		HpsrvorcaCrudServiceImpl srvOrCaService = new HpsrvorcaCrudServiceImpl();
		HPSrvorcaDO[] hpSrvOrCaDOs = srvOrCaService.find(whereStr, null,
				FBoolean.FALSE);
		if (!ArrayUtil.isEmptyNoNull(srvCateDOs)) {
			hpSrvOrCaDO = hpSrvOrCaDOs[0];
		}
		return hpSrvOrCaDO;
	}

}
