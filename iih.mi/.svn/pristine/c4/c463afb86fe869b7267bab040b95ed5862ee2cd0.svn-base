package iih.mi.itf2.service.bp.bdservice.treat;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.mi.itf2.dto.midirdownload.d.MiDirEnum;
import iih.mi.itf2.dto.treatandfwsscomp.d.TreatAndFwssCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

public class ReplaceTreatDataBP {
	
	private List<TreatAndFwssCompDTO> treatCompDTOs;
	private List<TreatAndFwssCompDTO> fwssCompDTOs;
	private List<TreatAndFwssCompDTO> cmCompDTOs;
	
	public TreatAndFwssCompDTO[] exec(TreatAndFwssCompDTO[] treatAndFwssCompDTOs) throws BizException{
		GetItemizeSave(treatAndFwssCompDTOs);
		String[] strid = null;
		if (this.treatCompDTOs!=null&&this.treatCompDTOs.size()>0) {
			strid = new String[this.treatCompDTOs.size()];
			strid = getCompIds(this.treatCompDTOs.toArray(new TreatAndFwssCompDTO[this.treatCompDTOs.size()]));
			UpdataSrvorcaStatus(strid,this.treatCompDTOs.get(0).getEu_status());
		}else if (this.fwssCompDTOs!=null&&this.fwssCompDTOs.size()>0) {
			strid = new String[this.fwssCompDTOs.size()];
			strid = getCompIds(this.fwssCompDTOs.toArray(new TreatAndFwssCompDTO[this.fwssCompDTOs.size()]));
			UpdataSrvorcaStatus(strid,this.fwssCompDTOs.get(0).getEu_status());
		}else if (this.cmCompDTOs!=null&&this.cmCompDTOs.size()>0) {
			strid = new String[this.cmCompDTOs.size()];
			strid = getCompIds(this.cmCompDTOs.toArray(new TreatAndFwssCompDTO[this.cmCompDTOs.size()]));
			UpdataSrvorcaStatus(strid,this.cmCompDTOs.get(0).getEu_status());
		}
		return treatAndFwssCompDTOs;
	}
	
	/**
	 * 更新医保目录对照状态到已审核
	 * 
	 * @param idSrvorcaArr
	 * @throws BizException
	 */
	private void UpdataSrvorcaStatus(String[] idSrvorcaArr,String eu_status) throws BizException {
		DAFacade daFacade = new DAFacade();
		String sql = GetUpdateSql(idSrvorcaArr,eu_status);
		daFacade.execUpdate(sql);
	}
	
	/**
	 * 获取更新Sql
	 * 
	 * @param idSrvorcaArr
	 * @return
	 */
	private String GetUpdateSql(String[] idSrvorcaArr,String eu_status) {
		String baseSql = String.format("UPDATE BD_HP_SRVORCA SET EU_STATUS = '%s'", eu_status);
		String whereInPart = SqlUtils.getInSqlByIds(HPSrvorcaDO.ID_HPSRVORCA, idSrvorcaArr);
		return String.format("%s WHERE %s", baseSql, whereInPart);
	}
	
	/**
	 * 获取主键
	 * @author zhang.hw
	 * @date 2019年7月19日
	 * @param treatAndFwssCompDTOs
	 * @return
	 */
	private String[] getCompIds(TreatAndFwssCompDTO[] treatAndFwssCompDTOs){
		List<String> list = new ArrayList<String>();
		for (TreatAndFwssCompDTO treatAndFwssCompDTO : treatAndFwssCompDTOs) {
			if (treatAndFwssCompDTO!=null&&treatAndFwssCompDTO.getId_hpsrvorca()!=null) {
				list.add(treatAndFwssCompDTO.getId_hpsrvorca());
			}
		}
		return list.toArray(new String[list.size()]);
	}
	
	/**
	 * 获取医保目录对照主键列表
	 * 
	 * @param drugCompDtos
	 * @return
	 */
	private void GetItemizeSave(TreatAndFwssCompDTO[] treatAndFwssCompDTOs) {
		for (TreatAndFwssCompDTO treatAndFwssCompDTO : treatAndFwssCompDTOs) {
			if (MiDirEnum.MIDIRSRV.equals(treatAndFwssCompDTO.getEu_hpsrvtp())) {
				if (this.treatCompDTOs==null) {
					this.treatCompDTOs = new ArrayList<TreatAndFwssCompDTO>();
				}
				this.treatCompDTOs.add(treatAndFwssCompDTO);
			}else if (MiDirEnum.MIDIRFACILITY.equals(treatAndFwssCompDTO.getEu_hpsrvtp())) {
				if (this.fwssCompDTOs==null) {
					this.fwssCompDTOs = new ArrayList<TreatAndFwssCompDTO>();
				}
				this.fwssCompDTOs.add(treatAndFwssCompDTO);
			}else if (MiDirEnum.MIDIRMC.equals(treatAndFwssCompDTO.getEu_hpsrvtp())) {
				if (this.cmCompDTOs==null) {
					this.cmCompDTOs = new ArrayList<TreatAndFwssCompDTO>();
				}
				this.cmCompDTOs.add(treatAndFwssCompDTO);
			}
		}
	}
	
}
