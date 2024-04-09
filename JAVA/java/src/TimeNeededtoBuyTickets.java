public class TimeNeededtoBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0;

        // If person k only needs one ticket, return the time to buy it
        if (tickets[k] == 1)
            return k + 1;

        // Continue buying tickets until person k buys all their tickets
        while (tickets[k] > 0) {
            for (int i = 0; i < n; i++) {
                // Buy a ticket at index 'i' if available
                if (tickets[i] != 0) {
                    tickets[i]--;
                    time++;
                }

                // If person k bought all their rickets, return the time
                if (tickets[k] == 0)
                    return time;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        TimeNeededtoBuyTickets ob=new TimeNeededtoBuyTickets();
        System.out.println(ob.timeRequiredToBuy(new int[] {2,3,2},  2));
    }
}
