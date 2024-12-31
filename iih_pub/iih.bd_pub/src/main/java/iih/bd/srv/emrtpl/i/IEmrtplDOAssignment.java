package iih.bd.srv.emrtpl.i;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.mrtpltreeitem.d.MrtplTreeItemDTO;
import xap.mw.core.data.BizException;

public interface IEmrtplDOAssignment {
	  /**
     * 集团模板Do赋初值
     * @throws BizException 
     */
    public abstract EmrTplDO[] getGrpmrtplDO(MrtplTreeItemDTO treedto) throws BizException;
 
    /**
     * 全院模板Do赋初值
     * @throws BizException 
     */
    public abstract EmrTplDO[] getHosmrtplDO(MrtplTreeItemDTO treedto) throws BizException;
 
    /**
     * 科室模板Do赋初值
     * @throws BizException 
     */
    public abstract EmrTplDO[] getDeptmrtplDO(MrtplTreeItemDTO treedto) throws BizException;
  
    /**
     * 个人模板Do赋初值
     * @throws BizException 
     */
    public abstract EmrTplDO[] getPermrtplDO(MrtplTreeItemDTO treedto) throws BizException;
  
    /*
     * 根据自定义分类获取最大排序号
     */
    public abstract int GetEmrTpDOByMrcactm(String id_mrcactm,String id_emp,String id_dept,String id_ownorg,String id_owtp) throws BizException;
}
