package calendar;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.Calendar;

public class calendarUI extends JFrame {

    private Calendar calendarInfo = Calendar.getInstance();


    public calendarUI() {
        super("Calendar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Container c = getContentPane();
        setForeground(Color.white);
        setBackground(Color.white);

        c.add(new JLabel(String.valueOf(calendarInfo.get(Calendar.MONTH) + 1)), BorderLayout.NORTH);
        c.add(new CalenderPanel(), BorderLayout.CENTER);
        setSize(700, 1000);
        setResizable(false);
        setVisible(true);

    }

    class CalenderPanel extends JPanel {
        private JLabel[] weekLabel = {
                new JLabel("SUN"),
                new JLabel("MON"),
                new JLabel("TUE"),
                new JLabel("WED"),
                new JLabel("THU"),
                new JLabel("FRI"),
                new JLabel("SAT")
        };

        private week[] weekPanel = {
                new week(weekLabel[0]),
                new week(weekLabel[1]),
                new week(weekLabel[2]),
                new week(weekLabel[3]),
                new week(weekLabel[4]),
                new week(weekLabel[5]),
                new week(weekLabel[6])
        };

        public CalenderPanel() {
            setPreferredSize(new Dimension(700, 700));
            setBackground(Color.WHITE);
            setOpaque(true);

            // 달력의 헤더.
            weekLabel[0].setForeground(Color.red);

            JPanel header = new JPanel();
            header.setLayout(new GridLayout(1, 7, 10, 10));
            header.setPreferredSize(new Dimension(630, 20));
            header.setBackground(Color.white);
            for(int i = 0; i < 7; i++){
                header.add(weekPanel[i]);
            }
            add(header, BorderLayout.CENTER);

            // 달력의 센터.

            JPanel center = new JPanel();
            center.setLayout(new GridLayout(0, 7, 10, 10));
            center.setPreferredSize(new Dimension(630, 450));
            // 1일이 무슨 요일인지 구하기 위해 계산.
            calendarInfo.set(calendarInfo.DAY_OF_MONTH, 1);
            int whatDayOfWeek = calendarInfo.get(Calendar.DAY_OF_WEEK);
            // 달력 채우기 (공백).
            for(int i = 1; i < whatDayOfWeek; i++){
                center.add(new DatePanel(0));
            }
            // 달력 채우기 (날짜)
            for(int i = 1; i <= calendarInfo.getActualMaximum(calendarInfo.DAY_OF_MONTH); i++){
                center.add(new DatePanel(i));
            }
            add(center, BorderLayout.CENTER);
        }
    }
    class week extends JPanel{
        public week(JLabel Info){
            setLayout(new FlowLayout(FlowLayout.CENTER));
            setBackground(Color.WHITE);
            setOpaque(true);
            add(Info);
            setVisible(true);
        }
    }
    class DatePanel extends JPanel {
        private Calendar Info;
        public DatePanel(int date){
            setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
            setBackground(Color.WHITE);
            setOpaque(true);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            if(date != 0){
                JLabel dateText = new JLabel("" + date);
                add(dateText);
            }
            setVisible(true);
        }
    }



}
