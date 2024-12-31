package iih.en.doc.s;

import iih.en.doc.i.IPregDocCmdService;
import iih.en.doc.pregdoc.d.PregDocDO;
import iih.en.doc.pregdoc.dto.d.PregDocDTO;
import iih.en.doc.pregdoc.dto.d.PregDocInfoDTO;
import iih.en.doc.s.bp.preg.s.ReserveSaveBP;
import iih.en.doc.s.bp.preg.s.SaveEustatus;
import iih.en.doc.s.bp.preg.s.SavePregDocBP;
import iih.en.doc.s.bp.preg.s.SavePregDocInfoBP;
import iih.en.doc.s.bp.preg.s.SendMessageBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 产科建档命令服务
 * 
 * @author renying
 *
 */
@Service(serviceInterfaces = { IPregDocCmdService.class }, binding = Binding.JSONRPC)
public class PregDocCmdServiceImpl implements IPregDocCmdService {
    /**
     * 保存建档信息
     * 
     * @param pregdocDto
     * @return
     * @throws BizException
     */
    @Override
    public void savePregDoc(PregDocDTO pregdocDto) throws BizException {
        SavePregDocBP saveBp = new SavePregDocBP();
        saveBp.exec(pregdocDto);
    }
    
    /**
     * 建档预约
     * 预约保存
     * 更新预约状态
     * 新增产妇状态记录
     * @param pregdocDto
     * @throws BizException
     */
    //任志 2018年3月7号 建档预约
    @Override
    public void reserveSave(PregDocDTO pregdocDto) throws BizException {
        ReserveSaveBP saveBP = new ReserveSaveBP();
        saveBP.exec(pregdocDto);
    }

    /**
     * 保存建档信息
     * 
     * @param pregdocDto
     * @return
     * @throws BizException
     */
    @Override
    public void savePregDocInfo(PregDocInfoDTO pregDocInfoDTO) throws BizException {
       SavePregDocInfoBP savePregDocInfoBP = new SavePregDocInfoBP();
       savePregDocInfoBP.exec(pregDocInfoDTO);

    }

    /**
     * 建档未就诊发送短信
     * 
     * @param pregDocInfos
     * @return
     * @throws BizException
     */
    public PregDocInfoDTO[] sendMessage(PregDocInfoDTO[] pregDocInfos) throws BizException {
        SendMessageBP bp = new SendMessageBP();
        return bp.exec(pregDocInfos);
    }

    /**
     * 修改预约状态
     * @param pregDocDto
     * @return
     * @throws BizException
     */
    @Override
    public PregDocDO updateEustatus(PregDocDTO pregDocDto) throws BizException {
        SaveEustatus saveEustatus = new SaveEustatus(); 
        return saveEustatus.exec(pregDocDto);
    }
}
