package iih.ci.diag.i;

import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.dto.d.DIDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;

public  interface ICidiagMaintainService {
	

    /**
     * 医嘱诊断 保存
     * id 诊断过程id
     * sd 诊断过程编码
     * @param diDTO
     * @return
     * @throws BizException
     */
    public abstract DIDTO[] SaveCiDiDto(DIDTO[] diDTO,String des,CiEnContextDTO cienContextDTO)throws BizException;
    
    
    /**
     * 诊断的保存  （包含事件）
     * @param CidiAggDO
     * @return
     * @throws BizException
     */
    public abstract CidiagAggDO SaveCiDi(CidiagAggDO CidiAggDO)throws BizException;
    /**
     * 删除诊断
     * @param ciDiagDo
     * @return
     * @throws BizException
     */
    public  CidiagAggDO DeleteCiDiag(CiDiagDO ciDiagDo)throws BizException;

    /**
     * 住院诊断保存
     * @param diDTO
     * @param des
     * @param cienContextDTO
     * @return
     * @throws BizException
     */
    public abstract  DIDTO[] SaveIPCiDiDto(DIDTO[] diDTO,String des,CiEnContextDTO cienContextDTO)throws BizException;
    /**
     * 作废诊断
     * @param id_ent
     * @return
     * @throws BizException
     */
    public abstract CiDiagDO[]  CancelCiDiagDO(String id_di,String id_emp)throws BizException;
    /**
     * 删除和作废住院诊断（签署的诊断作废，未签署的删除）
     * @param ciDiagDo
     * @param id_emp
     * @return
     * @throws BizException
     */
    public abstract CiDiagDO[] DeleteAndCancelIPCiDiag(CiDiagDO ciDiagDo,String id_emp)throws BizException;
    /**
     * 急诊抢救取本次抢救中前一次就诊的当前诊断保存
     * @param id_en
     * @return
     * @throws BizException
     */
    public abstract CidiagAggDO[] SaveLastDiagInThisRescue(String id_en,CiEnContextDTO ctx) throws BizException;
    
    public abstract CiDiagItemDO[] GetCiDiagItemDOs(String id_en) throws BizException;
}
