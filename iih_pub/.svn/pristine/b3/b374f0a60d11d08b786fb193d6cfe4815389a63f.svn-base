package iih.ci.mr.i;

import iih.ci.mr.cideathpatdto.d.CiDeathPatDTO;
import iih.ci.mr.d.CiMrDeathDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface ICiMrDeathService {
		/**
		 * 获取集成平台需要的病人死亡信息
		 * 
		 * @param id_apt
		 * @return
		 * @throws BizException
		 */
		public abstract CiMrDeathDTO getCiMrDeathDTO(String id_pat) throws BizException;
		
		/**
		 * 获取死亡报卡编码
		 * @param id_org
		 * @return
		 * @throws BizException
		 */
		public abstract int getCiMrDeathCode(String id_org) throws BizException;
		
		/**
		 * 校验组织下是否存在编码
		 * @param id_org
		 * @param healthNumber
		 * @return
		 * @throws BizException
		 */
		public abstract Boolean isExistHealthNumber(String id_org,String healthNumber) throws BizException;

		/**
		 * 获取死亡报卡患者列表
		 * @param qryRootNodeDTO
		 * @return
		 */
	    public abstract PagingRtnData<CiDeathPatDTO> getCiDeathPatDtoList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	    


}
