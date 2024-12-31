package iih.hp.cp.hpcpworkstatistic.s;
import java.util.List;

import  iih.hp.cp.hpcpworkstatistic.bp.HpCpWorkStatisticBP;
import  iih.hp.cp.hpcpworkstatistic.d.HpCpWorkStatisticDTO;

public class HpCpWorkStatisticService
{

	public List<HpCpWorkStatisticDTO> exe(String dt_start,String dt_end,String id_dep) throws Exception{
		HpCpWorkStatisticBP bp=new HpCpWorkStatisticBP();
		return bp.exe(dt_start, dt_end, id_dep);
	}
}