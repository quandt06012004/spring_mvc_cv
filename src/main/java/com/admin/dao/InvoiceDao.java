package com.admin.dao;

import java.util.List;

import com.admin.entities.Invoices;

public interface InvoiceDao {
	public List<Invoices> listInvoices();
	public boolean insertInvoice(Invoices in);
	public Invoices getInvoiceById(Integer inId);
	public boolean deleteInvoices(Integer inId);
	public boolean updateInvoice(Invoices in);
	List<Invoices> getInvoiceSearchId(Integer id);
}
