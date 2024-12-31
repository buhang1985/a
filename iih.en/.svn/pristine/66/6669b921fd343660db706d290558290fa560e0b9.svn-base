package iih.en.doc.s.bp.preg.s;

import iih.en.comm.validator.EnValidator;
import iih.en.doc.pregdoc.d.PregDocDO;
import iih.en.doc.pregdoc.dto.d.PregDocDTO;
import iih.en.doc.pregdoc.i.IPregdocMDOCudService;
import iih.en.doc.pregdoc.i.IPregdocMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 修改预约状态
 * @author renzhi
 *
 */
public class SaveEustatus {

    /**
     * 执行修改状态
     * @param pregDocDto
     * @return 
     * @throws BizException 
     */
    public PregDocDO exec(PregDocDTO pregDocDto) throws BizException {
        //判断产科建档id是否为空
        if (EnValidator.isEmpty(pregDocDto.getId_pregdoc())) {
            return null;
        }
        return this.update(pregDocDto);
    }
    
    /**
     * 修改预约状态
     * @param pregDocDto
     * @return
     * @throws BizException
     */
    private PregDocDO update(PregDocDTO pregDocDto) throws BizException {
        //增删改服务
        IPregdocMDOCudService cudService = ServiceFinder.find(IPregdocMDOCudService.class);
        //查询服务
        IPregdocMDORService rService = ServiceFinder.find(IPregdocMDORService.class);
        //根据产科建档id 查询产科建档记录
        PregDocDO rPregDocDO = rService.findById(pregDocDto.getId_pregdoc());
        rPregDocDO.setEu_status(pregDocDto.getEu_status().intValue());
        PregDocDO[] updateDate = cudService.update(new PregDocDO[] {rPregDocDO});
        return updateDate[0];
    }

}
