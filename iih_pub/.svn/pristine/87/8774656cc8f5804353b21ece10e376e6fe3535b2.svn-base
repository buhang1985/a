package iih.ci.mrm.i.mrmcatalog;

import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mrm.dto.mrmcatalog.d.MrmCataListDTO;
import iih.ci.mrm.dto.mrmcatalog.d.MrmCatalogerDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrmcatalogerdtoCrudService {
	
	
	//查询编目人
	public abstract PagingRtnData<MrmCatalogerDTO> getMrmCatalogerCrudQuery(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)throws BizException ;
	
	//查询已签收已编目患者
	public	abstract PagingRtnData<MrmCataListDTO> getMrmCatalogAssignQry(QryRootNodeDTO qryRootNodeDTO , PaginationInfo paginationInfo)throws BizException;
	
	//查询已签收待编目患者
	public  abstract PagingRtnData<MrmCataListDTO> getMrmUntalalogQry(QryRootNodeDTO qryRootNodeDTO , PaginationInfo paginationInfo)throws BizException;

	//保存数据到ci_amr
	public abstract FBoolean SaveAmrDO( MrmCatalogerDTO mrmcatalogerdto,MrmCataListDTO []mrmcatalistdto )throws BizException;

	//按钮撤销 赋值id_user_catalogue为null
	public abstract FBoolean SaveRepeal(MrmCataListDTO [] mrmcatalist)throws BizException;
}
