package busscript;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class TicketCheck {
	private static JTable table;
	private static JScrollPane scrollpane;
	
	@SuppressWarnings("serial")
	public TicketCheck() throws Exception {
		JFrame jf = new JFrame();
		jf.getContentPane().setBackground(Color.WHITE);
		
		jf.setSize(800,600);
		jf.getContentPane().setLayout(null);
		
		//테이블 그리기
		String[] header = {"출발일", "출발지", "도착지", "좌석", "금액"};
		ArrayList<TicketCheckVO> list = TicketCheckDAO.getReservationList();
		String[][] contents = new String[list.size()][5];
		for(int i=0; i<list.size(); i++) {
			contents[i][0] = list.get(i).getDeparture_date();
			contents[i][1] = list.get(i).getDeparture_point();
			contents[i][2] = list.get(i).getDestination();
			contents[i][3] = list.get(i).getSeat_num();
			contents[i][4] = String.valueOf(list.get(i).getPrice());
		}
		table = new JTable(new DefaultTableModel(contents, header) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		});
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		table.setRowHeight(30);

		//스크롤 패널 그리기
		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(12, 10, 760, 452);
		jf.getContentPane().add(scrollpane);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//닫는 부분 구현
			}
			
		});
		btnCancel.setBounds(118, 482, 169, 48);
		jf.getContentPane().add(btnCancel);
		
		JButton btnOK = new JButton("확인");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//list.get(table.getSelectedRow()) 넘겨서 티켓 정보 수정하는 창 띄우는 부분 구현
			}
		});
		btnOK.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnOK.setBackground(Color.WHITE);
		btnOK.setBounds(489, 482, 169, 48);
		jf.getContentPane().add(btnOK);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) throws Exception {
		TicketCheck tc = new TicketCheck();
	}
}
