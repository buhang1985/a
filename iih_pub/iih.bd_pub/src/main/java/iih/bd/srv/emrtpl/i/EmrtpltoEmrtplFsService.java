package iih.bd.srv.emrtpl.i;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.bd.srv.mrtpltreeitem.d.MrtplTreeItemDTO;
import xap.mw.core.data.BizException;

public interface EmrtpltoEmrtplFsService {
	
	  /**
     * 保存 保证事务统一
     * @throws BizException 
     */
    public void save(EmrTplDO[] tpldos,EmrTplStreamDO[] fsdos) throws BizException ;
 
	  /**
     * 更新 保证事务统一
     * @throws BizException 
     */
    public void update(EmrTplDO[] tpldos,EmrTplStreamDO[] fsdos) throws BizException ;
 
	  /**
     * 删除保证事务统一
     * @throws BizException 
     */
    public void delete(EmrTplDO[] tpldos,EmrTplStreamDO[] fsdos) throws BizException ;
   
    /**
     * 查询模板
     * @throws BizException 
     */
}
