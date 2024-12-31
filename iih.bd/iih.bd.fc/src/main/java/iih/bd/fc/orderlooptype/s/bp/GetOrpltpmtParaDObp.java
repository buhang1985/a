package iih.bd.fc.orderlooptype.s.bp;

import java.util.HashMap;

import iih.bd.fc.orderlooptype.d.OrpltpInfoDTO;
import iih.bd.fc.orpltpmtpara.d.OrpltpmtParaDO;
import iih.bd.fc.orpltpmtpara.i.IOrpltpmtparaRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2016年11月7日 下午4:43:25 
 * 类说明：查询闭环配置列表逻辑
 */
public class GetOrpltpmtParaDObp {

	public OrpltpmtParaDO[] exec() throws BizException {
		
		// 1、获取全部数据集合
		OrpltpmtParaDO[] dTOS = getOrpltpmtParaDOS();

		// 2、获取闭环显示明细
		HashMap<String, String> map= getOrpltpDesc();

		// 3、拼装闭环明细
		packageResult(dTOS, map);

		return dTOS;
	}

	/**
	 * 获取全部数据集合
	 * @return
	 * @throws BizException
	 */
	private OrpltpmtParaDO[] getOrpltpmtParaDOS() throws BizException {

		IOrpltpmtparaRService rService = ServiceFinder.find(IOrpltpmtparaRService.class);

		OrpltpmtParaDO[] paraDOs = rService.find(" 1=1 ", "", FBoolean.FALSE);

		return paraDOs;
	}

	/**
	 * 获取闭环显示明细
	 * 
	 * @param Id_orpltps
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, String>  getOrpltpDesc() throws BizException {

		HashMap<String, String> map = new HashMap<String, String>();
		
		getOrpltpInfoBp bp=new getOrpltpInfoBp();
		OrpltpInfoDTO[] infoDTOs= bp.exec();
		
		if(infoDTOs!=null && infoDTOs.length!=0){
			for (OrpltpInfoDTO orpltpInfoDTO : infoDTOs) {
				map.put(orpltpInfoDTO.getId_orpltp(), orpltpInfoDTO.getDes());
			}
		}
		
		return map;
	}

	/**
	 * 拼装闭环明细
	 * 
	 * @param dTOS
	 * @param map
	 */
	private void packageResult(OrpltpmtParaDO[] dTOS, HashMap<String, String> map) {

		if (dTOS != null && dTOS.length > 0) {

			for (OrpltpmtParaDO dto : dTOS) {

				dto.setOrpltp_des(map.get(dto.getId_orpltp()));
			}
		}

	}

}
