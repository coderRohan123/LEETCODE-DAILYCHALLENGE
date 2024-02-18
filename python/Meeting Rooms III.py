def mostBooked(n, meetings):
    room_availability_time = [0] * n
    meeting_count = [0] * n
    for start, end in sorted(meetings):
        min_room_availability_time =100000000#put max infinite
        min_available_time_room = 0
        found_unused_room = False
        for i in range(n):
            if room_availability_time[i] <= start:
                found_unused_room = True
                meeting_count[i] += 1
                room_availability_time[i] = end
                break
            if min_room_availability_time > room_availability_time[i]:
                min_room_availability_time = room_availability_time[i]
                min_available_time_room = i
        if not found_unused_room:
            room_availability_time[min_available_time_room] += end - start
            meeting_count[min_available_time_room] += 1

    return meeting_count.index(max(meeting_count))
print(mostBooked(3,[[1,20],[2,10],[3,5],[4,9],[6,8]]))