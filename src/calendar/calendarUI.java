package calendar;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.Calendar;

public class calendarUI extends JFrame {

    private Calendar calendarInfo = Calendar.getInstance();
    private CalenderPanel CalenderPart = new CalenderPanel();
    private MonthPanel MonthPart = new MonthPanel();

    public calendarUI() {
        super("Calendar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Container c = getContentPane();
        setForeground(Color.white);
        setBackground(Color.white);

        c.add(MonthPart, BorderLayout.NORTH);
        c.add(CalenderPart, BorderLayout.CENTER);

        setSize(700, 1000);
        setResizable(false);
        setVisible(true);
    }

    class RightButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(calendarInfo.get(Calendar.MONTH) < 11) {
                calendarInfo.set(Calendar.MONTH, calendarInfo.get(Calendar.MONTH) + 1);
                MonthPart.renew();
                CalenderPart.renew();
            }
        }
    }

    class LeftButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(calendarInfo.get(Calendar.MONTH) > 0) {
                calendarInfo.set(Calendar.MONTH, calendarInfo.get(Calendar.MONTH) - 1);
                MonthPart.renew();
                CalenderPart.renew();
            }
        }
    }

    class MonthPanel extends JPanel {
        private int thisMonth;
        private MonthLabel[] monthLabels = {
                new MonthLabel(0),
                new MonthLabel(1),
                new MonthLabel(2),
                new MonthLabel(3),
                new MonthLabel(4),
                new MonthLabel(5),
                new MonthLabel(6),
                new MonthLabel(7),
                new MonthLabel(8),
                new MonthLabel(9),
                new MonthLabel(10),
                new MonthLabel(11),
        };
        private JButton RightButton;
        private JButton LeftButton;

        public MonthPanel() {
            setLayout(new FlowLayout(FlowLayout.CENTER));
            setPreferredSize(new Dimension(630, 100));
            setBackground(Color.white);



            RightButton = new JButton(">");
            RightButton.setPreferredSize(new Dimension(60, 60) );
            RightButton.addActionListener(new RightButtonListener());

            LeftButton = new JButton("<");
            LeftButton.setPreferredSize(new Dimension(60, 60) );
            LeftButton.addActionListener(new LeftButtonListener());


            add(LeftButton);

            thisMonth = calendarInfo.get(Calendar.MONTH);
            add(monthLabels[thisMonth], BorderLayout.CENTER);

            add(RightButton);
        }

        public void renew(){
            remove(RightButton);
            remove(LeftButton);
            remove(monthLabels[thisMonth]);

            RightButton = new JButton(">");
            RightButton.setPreferredSize(new Dimension(60, 60) );
            RightButton.addActionListener(new RightButtonListener());

            LeftButton = new JButton("<");
            LeftButton.setPreferredSize(new Dimension(60, 60) );
            LeftButton.addActionListener(new LeftButtonListener());


            add(LeftButton);

            thisMonth = calendarInfo.get(Calendar.MONTH);
            add(monthLabels[thisMonth], BorderLayout.CENTER);

            add(RightButton);

            revalidate();
            repaint();
        }

    }

    class MonthLabel extends JLabel {
        public MonthLabel(int Month) {
            setFont(new Font("Serif", Font.BOLD, 70));
            setPreferredSize(new Dimension(200, 70));
            setHorizontalAlignment(JLabel.CENTER);
            setForeground(Color.black);
            setText(String.valueOf(Month + 1));
        }
    }

    class CalenderPanel extends JPanel {
        JPanel header = new JPanel();
        JPanel center = new JPanel();

        private JLabel[] weekLabel = {
                new JLabel("SUN"),
                new JLabel("MON"),
                new JLabel("TUE"),
                new JLabel("WED"),
                new JLabel("THU"),
                new JLabel("FRI"),
                new JLabel("SAT")
        };

        private WeekPanel[] weekPanel = {
                new WeekPanel(weekLabel[0]),
                new WeekPanel(weekLabel[1]),
                new WeekPanel(weekLabel[2]),
                new WeekPanel(weekLabel[3]),
                new WeekPanel(weekLabel[4]),
                new WeekPanel(weekLabel[5]),
                new WeekPanel(weekLabel[6])
        };

        public CalenderPanel() {
            setPreferredSize(new Dimension(700, 700));
            setBackground(Color.WHITE);
            setOpaque(true);

            // 달력의 헤더.
            weekLabel[0].setForeground(Color.red);


            header.setLayout(new GridLayout(1, 7, 10, 10));
            header.setPreferredSize(new Dimension(630, 20));
            header.setBackground(Color.white);
            for(int i = 0; i < 7; i++){
                header.add(weekPanel[i]);
            }
            add(header, BorderLayout.NORTH);


            center.setLayout(new GridLayout(0, 7, 10, 10));
            center.setPreferredSize(new Dimension(630, 450));

            calendarInfo.set(calendarInfo.DAY_OF_MONTH, 1);
            int whatDayOfWeek = calendarInfo.get(Calendar.DAY_OF_WEEK);

            for(int i = 1; i < whatDayOfWeek; i++){
                center.add(new DatePanel(0));
            }

            for(int i = 1; i <= calendarInfo.getActualMaximum(calendarInfo.DAY_OF_MONTH); i++){
                center.add(new DatePanel(i));
            }
            add(center, BorderLayout.CENTER);
        }

        public void renew(){
            remove(center);
            remove(header);

            header = new JPanel();
            header.setLayout(new GridLayout(1, 7, 10, 10));
            header.setPreferredSize(new Dimension(630, 20));
            header.setBackground(Color.white);
            for(int i = 0; i < 7; i++){
                header.add(weekPanel[i]);
            }
            add(header, BorderLayout.NORTH);

            center = new JPanel();
            center.setLayout(new GridLayout(0, 7, 10, 10));
            center.setPreferredSize(new Dimension(630, 450));

            calendarInfo.set(calendarInfo.DAY_OF_MONTH, 1);
            int whatDayOfWeek = calendarInfo.get(Calendar.DAY_OF_WEEK);

            for(int i = 1; i < whatDayOfWeek; i++){
                center.add(new DatePanel(0));
            }

            for(int i = 1; i <= calendarInfo.getActualMaximum(calendarInfo.DAY_OF_MONTH); i++){
                center.add(new DatePanel(i));
            }
            add(center, BorderLayout.CENTER);

            revalidate();
            repaint();

        }
    }
    class WeekPanel extends JPanel{
        public WeekPanel(JLabel Info){
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
