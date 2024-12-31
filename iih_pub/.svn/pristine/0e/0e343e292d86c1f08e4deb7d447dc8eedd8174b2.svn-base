package iih.en.doc.i;

import iih.en.doc.pregdoc.d.PregDocDO;
import iih.en.doc.pregdoc.dto.d.PregDocDTO;
import iih.en.doc.pregdoc.dto.d.PregDocInfoDTO;
import xap.mw.core.data.BizException;

/**
 * 建档命令服务
 * @author renying
 *
 */
public interface IPregDocCmdService {
	/**
	 * 保存建档信息
	 * @param pregdocDto
	 * @return
	 * @throws BizException
	 */
	void savePregDoc(PregDocDTO pregdocDto) throws BizException;
	
	/**
     * 保存pregDocInfo
     * @param pregDocInfo
     * @return
     * @throws BizException
     */
	void savePregDocInfo(PregDocInfoDTO pregDocInfo) throws BizException;
	
	/**
	 * 建档预约
	 * 预约保存
	 * 更新预约状态
	 * 新增产妇状态记录
	 * @param pregdocDto
	 * @throws BizException
	 */
	//任志 2018年3月7号 建档预约
	void reserveSave(PregDocDTO pregdocDto) throws BizException;
	
	/**
	 * 建档未就诊发送短信
	 * @param pregDocInfos
	 * @return
	 * @throws BizException
	 */
    PregDocInfoDTO[] sendMessage( PregDocInfoDTO[]  pregDocInfos)  throws BizException;

    /**
     * 修改预约状态
     * @param pregDocDto
     * @return
     * @throws BizException
     */
    PregDocDO updateEustatus(PregDocDTO pregDocDto) throws BizException;
    
}
