package com.multiple.billingCX.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.font.PdfType0Font;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.multiple.billingCX.model.Invoice;
import com.multiple.billingCX.model.Item;
import com.multiple.billingCX.model.Product;
import com.multiple.billingCX.service.InvoiceService;

@Controller
public class billingController {
	
	@Autowired
	private InvoiceService invoiceService;

	@GetMapping("/home")
	public String homePage(Model model) {
		model.addAttribute("invoices", invoiceService.all()!=null?invoiceService.all():new ArrayList<>());
		return "bill/home";
	}

	@RequestMapping(value = "getSteamingFile/{invoiceId}", method = RequestMethod.GET)
	public void getSteamingFile(HttpServletResponse response,@PathVariable("invoiceId")int invoiceId) throws IOException, ParseException {

		Invoice invoice = invoiceService.findById(invoiceId);
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"demo.pdf\"");
		billPdfGeneration(response,invoice);
	}

	public OutputStream billPdfGeneration(HttpServletResponse response,Invoice invoice) throws IOException, ParseException {
		OutputStream outputStream = response.getOutputStream();
		PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outputStream));
		PdfFont bold = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);
		
		Document document = new Document(pdfDocument);
//		document.add(new Paragraph("Hello World!"));

		document.add(new Paragraph().setTextAlignment(TextAlignment.RIGHT).setMultipliedLeading(1)
				.add(new Text(String.format("%s %s\n", "THIS IS NAME", invoice.getId())).setFont(bold).setFontSize(18).setBold())
				.add(convertDate(invoice.getInvoiceDate(), "MMM dd, yyyy")));

		document.add(getLineItemTable(invoice, bold));
		String[] test = {"Total"};
		String[] amt = {"100","200"};
		document.add(getTotalsTable(String.valueOf(invoice.getBaseCost()), String.valueOf(invoice.getTotalTax()), String.valueOf(invoice.getTotal()),
				"Rupee", bold));
		// step 5
		document.close();
		return outputStream;

	}
	
    public String convertDate(Date d, String newFormat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(newFormat);
        return sdf.format(d);
    }
    
    public Table getLineItemTable(Invoice invoice, PdfFont bold) {
        Table table = new Table(new UnitValue[]{
        		new UnitValue(UnitValue.PERCENT, 3f),
        		new UnitValue(UnitValue.PERCENT, 43f),
        		new UnitValue(UnitValue.PERCENT, 12f),
        		new UnitValue(UnitValue.PERCENT, 6f),
        		new UnitValue(UnitValue.PERCENT, 12f),
        		new UnitValue(UnitValue.PERCENT, 12f),
        		new UnitValue(UnitValue.PERCENT, 12f)})
        		.setWidthPercent(100)
				.setMarginTop(10).setMarginBottom(10);
        table.addHeaderCell(createCell("Sr. No.:", bold));
        table.addHeaderCell(createCell("Item:", bold));
        table.addHeaderCell(createCell("Price:", bold));
        table.addHeaderCell(createCell("Qty:", bold));
        table.addHeaderCell(createCell("Subtotal:", bold));
        table.addHeaderCell(createCell("Tax:", bold));
        table.addHeaderCell(createCell("Total:", bold));
        Product product;
        int i =1;
        for (Item item : invoice.getItems()) {
            product = item.getProduct();
            table.addCell(createCell(String.valueOf(i)).setTextAlignment(TextAlignment.RIGHT));
            table.addCell(createCell(product.getName()));
            table.addCell(createCell(
            	format2dec(Math.round(item.getCost())))
                .setTextAlignment(TextAlignment.RIGHT));
            table.addCell(createCell(String.valueOf(item.getQuantity()))
                .setTextAlignment(TextAlignment.RIGHT));
            table.addCell(createCell(
                format2dec(Math.round(item.getCost()*item.getQuantity())))
                .setTextAlignment(TextAlignment.RIGHT));
            table.addCell(createCell(
                format2dec(Math.round(item.getTax())))
                .setTextAlignment(TextAlignment.RIGHT));
           table.addCell(createCell(
                format2dec(Math.round(
                	item.getAmount())))
                .setTextAlignment(TextAlignment.RIGHT));
            i++;
        }
        return table;
    }
    
    public Table getTotalsTable(String tBase, String tTax, String tTotal, String tCurrency,
            PdfFont bold) {
        Table table = new Table(new UnitValue[]{
        	/*	new UnitValue(UnitValue.PERCENT, 8.33f),
        		new UnitValue(UnitValue.PERCENT, 8.33f),*/
        		new UnitValue(UnitValue.PERCENT, 25f),
        		new UnitValue(UnitValue.PERCENT, 25f),
        		new UnitValue(UnitValue.PERCENT, 25f),
        		new UnitValue(UnitValue.PERCENT, 8.34f)})
        		.setHorizontalAlignment(HorizontalAlignment.RIGHT)
        	.setWidthPercent(100);
//        table.addCell(createCell("Total Tax:", bold));
//        table.addCell(createCell("%", bold)
//        	.setTextAlignment(TextAlignment.RIGHT));
        table.addCell(createCell("Base amount:", bold));
        table.addCell(createCell("Tax amount:", bold));
        table.addCell(createCell("Total:", bold));
        table.addCell(createCell("Curr.:", bold));
//        int n = type.length;
//        for (int i = 0; i < n; i++) {
//            table.addCell(createCell(totalTax)
//            	.setTextAlignment(TextAlignment.RIGHT));
//            table.addCell(createCell(percentage[i])
//            	.setTextAlignment(TextAlignment.RIGHT));
/*            table.addCell(createCell(baseAmount)
            	.setTextAlignment(TextAlignment.RIGHT));
            table.addCell(createCell(taxAmount)
            	.setTextAlignment(TextAlignment.RIGHT));
            double total = Double.parseDouble(base[i]) + Double.parseDouble(tax[i]);
            table.addCell(createCell(
            	format2dec(Math.round(total)))
            	.setTextAlignment(TextAlignment.RIGHT));
            table.addCell(createCell(currency[i]));*/
//        }
//        table.addCell(new Cell(1, 2).setBorder(Border.NO_BORDER));
        table.addCell(createCell(tBase, bold)
        	.setTextAlignment(TextAlignment.RIGHT));
        table.addCell(createCell(tTax, bold)
        	.setTextAlignment(TextAlignment.RIGHT));
        table.addCell(createCell(tTotal, bold)
        	.setTextAlignment(TextAlignment.RIGHT));
        table.addCell(createCell(tCurrency, bold).setTextAlignment(TextAlignment.RIGHT));
        return table;
    }
    public Cell createCell(String text, PdfFont font) {
    	return new Cell().setPadding(0.8f)
        	.add(new Paragraph(text)
        		.setFont(font).setMultipliedLeading(1));
    }
    
    public Cell createCell(String text) {
    	return new Cell().setPadding(0.8f)
    		.add(new Paragraph(text)
    			.setMultipliedLeading(1));
    }
    
    public static String format2dec(double d) {
        return String.format("%.2f", d);
    }
    
    public Invoice sampleData() {
    	Invoice invoice = new Invoice();
    	Product p = new Product();
    	p.setName("iphone");
    	p.setPrice(80000);
//    	p.setVat(10);
    	p.setId(1);
    	
    	Product p2 = new Product();
    	p2.setName("nokia");
    	p2.setPrice(10000);
//    	p2.setVat(10);
    	p2.setId(2);
    	Set<Item> itemList = new HashSet<>();
    	
    	Item item = new Item();
    	
    	item.setQuantity(10);
    	item.setProduct(p);
    	item.setId(1);
    	item.setCost(p.getPrice()*item.getQuantity());
    	itemList.add(item);
    	
    	Item item1 = new Item();
    	
    	item1.setQuantity(20);
    	item1.setProduct(p2);
    	item1.setCost(p2.getPrice()*item1.getQuantity());
    	item1.setId(2);
    	itemList.add(item1);
    	
    	
    	invoice.setItems(itemList);
    	return invoice;
    }

}
