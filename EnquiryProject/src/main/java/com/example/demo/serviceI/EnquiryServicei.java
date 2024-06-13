package com.example.demo.serviceI;

import java.util.List;

import com.example.demo.controller.CibilDemo;
import com.example.demo.model.EnquiryModel;

public interface EnquiryServicei {

	public void saveEnquiryData(EnquiryModel em);

	public List<EnquiryModel> getData();

	public EnquiryModel getEnquiryById(int id);

	public EnquiryModel updateEnquiry(int id, EnquiryModel e);

	public void deleteEnquiryById(int id);

	public List<EnquiryModel> getByCibilStatus(String cibilStatus);

}
