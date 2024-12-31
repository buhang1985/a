package iih.bd.srv.pub;

public interface IBdSrvSqlConst {

	/**
	 * 医疗服务查询中，MedSrvDO查询SQL字符串
	 * 主要是调优时使用。
	 * 如果不是明显性能优越，则不要使用这个方法
	 * 一般建议使用基本服务进行查询
	 */
	public static final String BDSRV_MEDSRVDO_SQLSTR="select a0.Code, a0.Createdby, a0.Createdtime, a0.Des, a0.Des_pri, a0.Ds, a0.Eu_blmd, a0.Fg_active, a0.Fg_bl, a0.Fg_ctm, a0.Fg_mm, a0.Fg_or, a0.Fg_set, a0.Fg_use_er,"
			   +" a0.Fg_use_fm, a0.Fg_use_ip, a0.Fg_use_op, a0.Fg_use_pe, a0.Id_boil, a0.Id_boildes, a0.Id_freq, a0.Id_grp, a0.Id_mmbind_er, a0.Id_mmbind_fm, a0.Id_mmbind_ip, "
			   +" a0.Id_mmbind_op, a0.Id_mmbind_pe, a0.Id_org, a0.Id_primd, a0.Id_pritp, a0.Id_route, a0.Id_routedes, a0.Id_setord, a0.Id_srv, a0.Id_srvca, a0.Id_srvtp, "
			   +" a0.Id_unit_med, a0.Mnecode, a0.Modifiedby, a0.Modifiedtime, a0.Name, a0.Note, a0.Pri, a0.Pycode, a0.Quan_med, a0.Sd_mmbind_er, a0.Sd_mmbind_fm, a0.Sd_mmbind_ip,"
			   +" a0.Sd_mmbind_op, a0.Sd_mmbind_pe, a0.Sd_primd, a0.Sd_pritp, a0.Sd_setord, a0.Sd_srvtp, a0.Shortname, a0.Srvca_innercode, a0.Sv, a0.Wbcode "
			   +" ,udi1.code as srvtp_code,udi1.name as srvtp_name"
			   +" ,ca.id_srvtp as id_srvtp_ca,ca.sd_srvtp as code_srvtp_ca,ca.code as srvca_code,ca.name as srvca_name"
			   +" ,me.code as med_code,me.name as med_name"
			   +" ,freq.fg_long,freq.fg_prnor,freq.code as freq_code,freq.name as freq_name,freq.freqct,freq.frequnitct,freq.sd_frequnitct"
			   +" ,route.code as route_code,route.name as route_name,route.mnecode as route_mnecode"
			   +" ,routedes.code as routedes_code,routedes.name as routedes_name,routedes.mnecode as routedes_mnecode"
			   +" ,boil.code as boil_code,boil.name as boil_name,boil.mnecode as boil_mnecode"
			   +" ,boildes.code as boildes_code,boildes.name as boildes_name,boildes.mnecode as boildes_mnecode"
			   +" ,pri.code as primd_code,pri.name as primd_name"
			   +" ,udi2.code as setord_code,udi2.name as setord_name"
			   +" ,udi3.code as op_code,udi3.name as op_name"
			   +" ,udi4.code as ip_code,udi4.name as ip_name"
			   +" ,udi5.code as er_code,udi5.name as er_name"
			   +" ,udi6.code as pe_code,udi6.name as pe_name"
			   +" ,udi7.code as fm_code,udi7.name as fm_name"
			   +" ,udi8.code as code_pritp,udi8.name as name_pritp"
			   +" ,inc1.name as inccaitmop_name,inc2.name as inccaitmip_name"
			   +" from bd_srv a0 "
			   +"      left outer join bd_udidoc udi1 on a0.id_srvtp=udi1.id_udidoc"
			   +"      left outer join bd_srvca ca on a0.id_srvca=ca.id_srvca"
			   +"      left outer join bd_measdoc me on a0.id_unit_med=me.id_measdoc"
			   +"      left outer join bd_freq freq on a0.id_freq=freq.id_freq"
			   +"      left outer join bd_route route on a0.id_route=route.id_route"
			   +"      left outer join bd_route_des routedes on a0.id_routedes=routedes.id_routedes"
			   +"      left outer join bd_boil boil on a0.id_boil=boil.id_boil"
			   +"      left outer join bd_boil_des boildes on a0.id_boildes=boildes.id_boildes " 
			   +"      left outer join bd_pri pri on a0.id_primd=pri.id_pri"
			   +"      left outer join bd_udidoc udi2 on a0.id_setord=udi2.id_udidoc"
			   +"      left outer join bd_udidoc udi3 on a0.id_mmbind_op=udi3.id_udidoc"
			   +"      left outer join bd_udidoc udi4 on a0.id_mmbind_ip=udi4.id_udidoc"
			   +"      left outer join bd_udidoc udi5 on a0.id_mmbind_er=udi5.id_udidoc"
			   +"      left outer join bd_udidoc udi6 on a0.id_mmbind_pe=udi6.id_udidoc"
			   +"      left outer join bd_udidoc udi7 on a0.id_mmbind_fm=udi7.id_udidoc"
			   +"      left outer join bd_udidoc udi8 on a0.id_pritp=udi8.id_udidoc"
			   +"      left outer join bd_incca inc1 on a0.incca_op=inc1.id_incca"
			   +"      left outer join bd_incca inc2 on a0.incca_ip=inc2.id_incca";
			  // +"   where a0.Id_srv =? ";	
}
