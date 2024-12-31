package iih.bd.pp.hpsrvorca.s.bp;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案查询医保目录对照分页信息
 * 
 * @author hao_wu
 *
 */
public class FindPagingByQCondBp {

	public PagingRtnData<HPSrvorcaDO> exec(QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg)
			throws BizException {
		PagingRtnData<HPSrvorcaDO> result = FindPagingByQCond(qryRootNodeDTO, orderStr, pg);
		setMiInfo(result);
		return result;
	}
	
	public PagingRtnData<HPSrvorcaDO> exec(HPDO hpdo,QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg)
			throws BizException {
		String whereParam = GetWherePartByQCond(qryRootNodeDTO);
		StringBuilder sqlParam = null;
		if (whereParam==null) {
			sqlParam = new StringBuilder();
			sqlParam.append(" id_hp='").append(hpdo.getId_hp()).append("' ");
		}else{
			sqlParam = new StringBuilder(whereParam);
			sqlParam.append(" and id_hp='").append(hpdo.getId_hp()).append("' ");
		}
		PagingRtnData<HPSrvorcaDO> result = FindPagingByQCond(sqlParam.toString(), orderStr, pg);
		setMiInfo(result);
		return result;
	}
	
	/**
	 * 
	 * @author zhang.hw
	 * @date 2019年9月17日
	 * @param string
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException 
	 */
	private PagingRtnData<HPSrvorcaDO> FindPagingByQCond(String sqlParam, String orderStr, PaginationInfo pg) throws BizException {
		IHpsrvorcaRService hpsrvorcaRService = ServiceFinder.find(IHpsrvorcaRService.class);
		PagingRtnData<HPSrvorcaDO> result = hpsrvorcaRService.findByPageInfo(pg, sqlParam, orderStr);
		return result;
	}

	/**
	 * 使用查询方案生成条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String GetWherePartByQCond(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		if (qryRootNodeDTO != null) {
			IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
			String wherePart = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRootNodeDTO);
			return wherePart;
		}
		return null;
	}

	/**
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<HPSrvorcaDO> FindPagingByQCond(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		IHpsrvorcaRService hpsrvorcaRService = ServiceFinder.find(IHpsrvorcaRService.class);
		PagingRtnData<HPSrvorcaDO> result = hpsrvorcaRService.findByQCondAndPageInfo(qryRootNodeDTO, orderStr, pg);
		return result;
	}

	/**
	 * 设置HIS信息
	 * 
	 * @param result
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void setMiInfo(PagingRtnData<HPSrvorcaDO> result) throws BizException {
		SetMiInfoBp bp = new SetMiInfoBp();
		bp.exec((HPSrvorcaDO[]) result.getPageData().toArray(new HPSrvorcaDO[0]));
	}
}
