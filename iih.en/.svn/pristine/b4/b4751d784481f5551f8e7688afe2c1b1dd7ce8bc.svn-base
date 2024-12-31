package iih.en.doc.s.bp.preg.s;


import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.validator.EnValidator;
import iih.en.doc.pregdoc.d.PregDocDO;
import iih.en.doc.pregdoc.d.PregDocStatDO;
import iih.en.doc.pregdoc.dto.d.PregDocInfoDTO;
import iih.en.doc.pregdoc.i.IPregDocStatDOCudService;
import iih.en.doc.pregdoc.i.IPregDocStatDORService;
import iih.en.doc.pregdoc.i.IPregdocMDOCudService;
import iih.en.doc.pregdoc.i.IPregdocMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存PregDocInfoDTO
 * 
 * @author renzhi
 *
 */
public class SavePregDocInfoBP {

    /**
     * 保存建档信息
     * 
     * @param pregdocDto
     * @return
     * @throws BizException
     */
    public void exec(PregDocInfoDTO pregDocInfoDTO) throws BizException {
        //产妇状态表PregDocStatDO
        this.validateParam(pregDocInfoDTO);
        this.savePregDocStatDo(pregDocInfoDTO);
        return;
    }
    
    /**
     * 验证参数是否为空
     * 
     * @param pregdocDto
     * @throws BizException
     */
    @SuppressWarnings("unused")
    private void validateParam(PregDocInfoDTO pregDocInfoDTO) throws BizException {
        if (pregDocInfoDTO == null) {
            throw new BizException(IEnMsgConst.ERROR_PREGDOC_NULL);
        }
        if (EnValidator.isEmpty(pregDocInfoDTO.getId_entdoc())) {
            throw new BizException(IEnMsgConst.ERROR_DOC_PATID_NOT_EXIST);
        }
    }
    
    /**
     * 更新产妇状态表
     * 
     * @param pregdocDto
     * @throws BizException
     */
    @SuppressWarnings("unused")
    private void savePregDocStatDo(PregDocInfoDTO pregDocInfoDTO) throws BizException {
        //获取查询服务对象
        IPregDocStatDORService docStatDORService = ServiceFinder.find(IPregDocStatDORService.class);
        //根据主键查询对应对象
        PregDocStatDO pregDocStatDo = docStatDORService.findById(pregDocInfoDTO.getId_pregdocstat());
        //高血压标识
        pregDocStatDo.setFg_hypert(pregDocInfoDTO.getFg_hypert());
        //糖尿病妊娠
        pregDocStatDo.setFg_diab_preg(pregDocInfoDTO.getFg_diab_preg());
        //妊娠糖尿病
        pregDocStatDo.setFg_preg_diab(pregDocInfoDTO.getFg_preg_diab());
        //建档体重
        pregDocStatDo.setWeit_doc(pregDocInfoDTO.getWeit_doc());
        //以分娩标识
        pregDocStatDo.setFg_have_born(pregDocInfoDTO.getFg_have_born());
        //分娩时长
        pregDocStatDo.setMins_born(pregDocInfoDTO.getMins_born());
        //分娩体重
        pregDocStatDo.setWeit_born(pregDocInfoDTO.getWeit_born());
        //产后出血量
        pregDocStatDo.setVol_out_blood(pregDocInfoDTO.getVol_out_blood());
        //早产标识
        pregDocStatDo.setFg_premature(pregDocInfoDTO.getFg_premature());
        //怀孕次数
        pregDocStatDo.setTimes_preg(pregDocInfoDTO.getTimes_preg());
        //生产次数
        pregDocStatDo.setTimes_born(pregDocInfoDTO.getTimes_born());
        //获取保存服务
        IPregDocStatDOCudService docStatDOCudService = ServiceFinder.find(IPregDocStatDOCudService.class);
        docStatDOCudService.update(new PregDocStatDO [] {pregDocStatDo} );
        if (pregDocInfoDTO.getFg_have_born()== FBoolean.TRUE) {
            this.updateEu_state(pregDocInfoDTO);
        }
    }
    
    /**
     * 修改状态
     * @param pregDocInfoDTO
     * @throws BizException
     */
    private void updateEu_state(PregDocInfoDTO pregDocInfoDTO) throws BizException {
        //增删改服务
        IPregdocMDOCudService cudService = ServiceFinder.find(IPregdocMDOCudService.class);
        //查询服务
        IPregdocMDORService rService = ServiceFinder.find(IPregdocMDORService.class);
        
        PregDocDO queryDo = rService.findById(pregDocInfoDTO.getId_pregdoc());
        
        queryDo.setEu_status(IEnConst.CONST_DOC_CANCEL);
        cudService.update(new PregDocDO[] {queryDo});
        
    }
}
