package ru.alljoint.atctt.ui;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.alljoint.atctt.entity.Claim;
import ru.alljoint.atctt.entity.Person;
import ru.alljoint.atctt.entity.Service;
import ru.alljoint.atctt.entity.Subservice;
import ru.alljoint.atctt.repository.PersonRepository;
import ru.alljoint.atctt.repository.ServiceRepository;
import ru.alljoint.atctt.repository.SubserviceRepository;

public class MainController {
	@Autowired
	private SubserviceRepository subServRepo;
	@Autowired
	private ServiceRepository servRepo;
	@Autowired
	private PersonRepository personRepo;

	public static class ReportLine implements Serializable {
		private static final long serialVersionUID = 8133163270450338355L;
		private String orderId;
		private String createDate;
		private String formCode;
		private String status;
		private String fullName;
		private String categoryOfRecipient;
		private String servName;
		private String subservName;
		private String deptName;
		
		public ReportLine() {
		}

		public ReportLine(String orderId, String createDate, String formCode, String status, String fullName,
				String categoryOfRecipient, String servName, String subservName, String deptName) {
			super();
			this.orderId = orderId;
			this.createDate = createDate;
			this.formCode = formCode;
			this.status = status;
			this.fullName = fullName;
			this.categoryOfRecipient = categoryOfRecipient;
			this.servName = servName;
			this.subservName = subservName;
			this.deptName = deptName;
		}

		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}

		public void setCreateDate(String createDate) {
			this.createDate = createDate;
		}

		public void setFormCode(String formCode) {
			this.formCode = formCode;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public void setCategoryOfRecipient(String categoryOfRecipient) {
			this.categoryOfRecipient = categoryOfRecipient;
		}

		public void setServName(String servName) {
			this.servName = servName;
		}

		public void setSubservName(String subservName) {
			this.subservName = subservName;
		}

		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}

		public String getOrderId() {
			return orderId;
		}

		public String getCreateDate() {
			return createDate;
		}

		public String getFormCode() {
			return formCode;
		}

		public String getStatus() {
			return status;
		}

		public String getFullName() {
			return fullName;
		}

		public String getCategoryOfRecipient() {
			return categoryOfRecipient;
		}

		public String getServName() {
			return servName;
		}

		public String getSubservName() {
			return subservName;
		}

		public String getDeptName() {
			return deptName;
		}
		
	}
	
	@FXML private TableView<ReportLine> table;
	@FXML private BarChart<String, Number> barChart;
	@FXML private RadioButton ieRadio;
	@FXML private RadioButton leRadio;
	@FXML private RadioButton npRadio;
	
	private Claim selClaim;
    
    private ObservableList<ReportLine> data;
    
    @FXML
    public void initialize() {
    }
    
    private void prepareData() {
		if (subServRepo.count() <= 0) {
			Random random = new Random();
			for (int i = 0; i < 100; i++) {
				String targetCode = String.valueOf(random.nextInt(10)) + String.valueOf(random.nextInt(10))
						+ String.valueOf(random.nextInt(10));
				Subservice sub = new Subservice(String.valueOf(i), targetCode, "Подуслуга " + i);
				subServRepo.save(sub);
			}
		}
		if (servRepo.count() <= 0) {
			Random random = new Random();
			String[] deps = {
					"Ведомство 1",
					"Ведомство 2",
					"Ведомство 3",
					"Ведомство 4",
			};
			int subservCount = (int)subServRepo.count();
			for (int i = 0; i < 100; i++) {
				String targetCode = String.valueOf(random.nextInt(10)) + String.valueOf(random.nextInt(10))
						+ String.valueOf(random.nextInt(10));
				String formCode = String.valueOf(random.nextInt(10)) + String.valueOf(random.nextInt(10))
				+ String.valueOf(random.nextInt(10)) + String.valueOf(random.nextInt(10))
				+ String.valueOf(random.nextInt(10));
				String deptCode = String.valueOf(random.nextInt(10)) + String.valueOf(random.nextInt(10));
				int subsCount = random.nextInt(5)+1;
				List<Subservice> subs = new ArrayList<>(subsCount);
				for (int j = 0; j < subsCount; j++) {
					subs.add(subServRepo.findOne(String.valueOf(random.nextInt(subservCount))));
				}
				Service serv = new Service(String.valueOf(i), targetCode, formCode,
						(random.nextBoolean() ? Claim.IE : (random.nextBoolean() ? Claim.LE : Claim.NP)),
						subs, deps[random.nextInt(deps.length)], "Услуга " + i, deptCode);
				servRepo.save(serv);
			}
		}
		if (personRepo.count() <= 0) {
			Random random = new Random();
			int servCount = (int)servRepo.count();
			for (int i = 0; i < 5000; i++) {
				Person person = new Person(String.valueOf(i),
						"Фамилия" + random.nextInt(100) +
						" Имя" + random.nextInt(100) +
						" Отчество" + random.nextInt(100),
						String.valueOf(Math.abs(random.nextInt())),
						String.valueOf(random.nextInt(servCount)),
						randomDate(), random.nextBoolean());
				personRepo.save(person);
			}
		}
    }
    
	private Date randomDate() {
		Long max = 0L;
        Long min = 700000000L;

        Random r = new Random();
        Long randomLong= System.currentTimeMillis() - (r.nextLong() % (max - min)) - min;
        return new Date(randomLong);
    }
    
    @PostConstruct
    public void init() {
    	prepareData();
    	constructTable();
    	constructChart();
    }
    
    @FXML
    public void ieRadioAction() {
    	selClaim = Claim.IE;
    	updateChart();
    }
    
    @FXML
    public void leRadioButton() {
    	selClaim = Claim.LE;
    	updateChart();
    }
    
    @FXML
    public void npRadioButton() {
    	selClaim = Claim.NP;
    	updateChart();
    }
    
    private void updateChart() {
    	barChart.getData().clear();
    	List<Service> servs = servRepo.findByClaim(selClaim);
		if (servs != null && !servs.isEmpty()) {
			List<String> servIds = servs.stream()
					.filter(s -> s != null && s.getServiceId() != null && !s.getServiceId().isEmpty())
					.collect(() -> new ArrayList<String>(), (list, item) -> list.add(item.getServiceId()),
							(list1, list2) -> list1.addAll(list2));
			String regexp = "(" + String.join("|", servIds) + ")";
			Iterable<Person> iter = personRepo.findByServiceIds(regexp);
			Map<LocalDate, Long> chartData = new HashMap<>();
	        ZoneId defaultZoneId = ZoneId.systemDefault();
			for (Person p : iter) {
				if (p.getCreateDate() != null) {
					LocalDate date = p.getCreateDate().toInstant().atZone(defaultZoneId).toLocalDate();
					Long number = chartData.get(date);
					if (number == null)
						number = 0L;
					chartData.put(date, ++number);
				}
			}
			
	    	XYChart.Series series1 = new XYChart.Series();
	        series1.setName(selClaim.getTitle());
	        for (Map.Entry<LocalDate, Long> entry : chartData.entrySet()) {
	        	series1.getData().add(new XYChart.Data(entry.getKey().toString(),
	        			entry.getValue()));
	        }
			
	        barChart.getData().addAll(series1);
	        
//	        Date date = new Date();
//	        Instant instant = date.toInstant();
//	        LocalDate l1 = instant.atZone(defaultZoneId).toLocalDate();
		}
    }
    
    private void constructChart() {
    	ToggleGroup group = new ToggleGroup();
    	ieRadio.setToggleGroup(group);
    	leRadio.setToggleGroup(group);
    	npRadio.setToggleGroup(group);
    	
//    	XYChart.Series series1 = new XYChart.Series();
//        series1.setName("2003");       
//        series1.getData().add(new XYChart.Data("1", 25601.34));
//        series1.getData().add(new XYChart.Data("2", 20148.82));
//        series1.getData().add(new XYChart.Data("3", 10000));
//        series1.getData().add(new XYChart.Data("4", 35407.15));
//        series1.getData().add(new XYChart.Data("5", 12000));   
//        
//        barChart.getData().addAll(series1);
    }
    
    private void constructTable() {
        List<ReportLine> orders = obtainTableData();
        data = FXCollections.observableArrayList(orders);

        // Добавляем столбцы к таблице
        TableColumn<ReportLine, String> orderIdColumn = new TableColumn<>("Номер заявки");
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        orderIdColumn.setStyle("-fx-alignment: TOP-RIGHT;");
        orderIdColumn.setMinWidth(100);
        orderIdColumn.setMaxWidth(150);

        TableColumn<ReportLine, String> createDateColumn = new TableColumn<>("Дата");
        createDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        createDateColumn.setStyle("-fx-alignment: TOP-CENTER;");
        createDateColumn.setMinWidth(70);
        createDateColumn.setMaxWidth(150);

        TableColumn<ReportLine, String> formCodeColumn = new TableColumn<>("Код формы");
        formCodeColumn.setCellValueFactory(new PropertyValueFactory<>("formCode"));
        formCodeColumn.setStyle("-fx-alignment: TOP-RIGHT;");
        formCodeColumn.setMinWidth(50);
        formCodeColumn.setMaxWidth(50);

        TableColumn<ReportLine, String> statusColumn = new TableColumn<>("Статус");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusColumn.setStyle("-fx-alignment: TOP-CENTER;");
        statusColumn.setMinWidth(50);
        statusColumn.setMaxWidth(70);

        TableColumn<ReportLine, String> fullNameColumn = new TableColumn<>("ФИО заявителя");
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        fullNameColumn.setStyle("-fx-alignment: TOP-LEFT;");
        fullNameColumn.setMinWidth(100);
        fullNameColumn.setMaxWidth(500);
        
        TableColumn<ReportLine, String> categoryOfRecipientColumn = new TableColumn<>("Категория заявителя");
        categoryOfRecipientColumn.setCellValueFactory(new PropertyValueFactory<>("categoryOfRecipient"));
        categoryOfRecipientColumn.setStyle("-fx-alignment: TOP-LEFT;");
        categoryOfRecipientColumn.setMinWidth(70);
        categoryOfRecipientColumn.setMaxWidth(150);
        
        TableColumn<ReportLine, String> servNameColumn = new TableColumn<>("Название услуги");
        servNameColumn.setCellValueFactory(new PropertyValueFactory<>("servName"));
        servNameColumn.setStyle("-fx-alignment: TOP-LEFT;");
        servNameColumn.setMinWidth(100);
        servNameColumn.setMaxWidth(200);
        
        TableColumn<ReportLine, String> subservNameColumn = new TableColumn<>("Название подуслуги");
        subservNameColumn.setCellValueFactory(new PropertyValueFactory<>("subservName"));
        subservNameColumn.setStyle("-fx-alignment: TOP-LEFT;");
        subservNameColumn.setMinWidth(100);
        subservNameColumn.setMaxWidth(200);
        
        TableColumn<ReportLine, String> deptNameColumn = new TableColumn<>("Название ведомства");
        deptNameColumn.setCellValueFactory(new PropertyValueFactory<>("deptName"));
        deptNameColumn.setStyle("-fx-alignment: TOP-LEFT;");
        deptNameColumn.setMinWidth(100);
        deptNameColumn.setMaxWidth(200);

        table.getColumns().setAll(orderIdColumn, createDateColumn, formCodeColumn, statusColumn,
        		fullNameColumn, categoryOfRecipientColumn, servNameColumn, subservNameColumn,
        		deptNameColumn);

        // Добавляем данные в таблицу
        table.setItems(data);
    }
    
    private List<ReportLine> obtainTableData() {
    	long count = personRepo.count();
    	List<ReportLine> orders = new ArrayList<>((int)count);
    	DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
    	
    	Map<String, Service> servCache = new HashMap<>();
    	
    	for (Person p : personRepo.findAll()) {
    		Service serv = servCache.get(p.getServiceId());
    		if (serv == null) {
    			serv = servRepo.findOne(p.getServiceId());
    			if (serv != null)
    				servCache.put(p.getServiceId(), serv);
    		}
    		String ssnames = null;
			if (serv.getSubservices() != null && serv.getSubservices().size() > 0) {
				ssnames = String.join(",\n", serv.getSubservices().stream().filter(s -> s != null && s.getName() != null)
						.collect(
				                ()->new ArrayList<String>(), // создаем ArrayList
				                (list, item)->list.add(item.getName()), // добавляем в список элемент
				                (list1, list2)-> list1.addAll(list2)));
			}
    		ReportLine rl = new ReportLine(
    				p.getOrderId(),
    				df.format(p.getCreateDate()),
    				/*formCode*/ (serv != null ? serv.getFormCode() : null),
    				(p.isStatus() ? "Открыта" : "Закрыта"),
    				p.getFullName(),
    				/*categoryOfRecipient*/ (serv != null ? serv.getCategoryOfRecipients().getTitle() : null),
    				/*servName*/ (serv != null ? serv.getName() : null),
    				/*subservName*/ ssnames,
    				/*deptName*/ (serv != null ? serv.getDepartment() : null));
    		orders.add(rl);
    	}
    	
    	return orders;
    }
}
