Map<Integer, Integer> valueToCount = new HashMap<>();
		int max = 0;
		for (int num : nums) {
			int count = valueToCount.getOrDefault(num, 0) + 1;
			valueToCount.put(num, count);
			max = Math.max(max, count);
		}

		System.out.println(valueToCount);

		List<List<Integer>> buckets = new ArrayList<>();
		for (int i = 0; i <= max; i++) {
			buckets.add(new ArrayList<>());
		}

		for (Map.Entry<Integer, Integer> entry : valueToCount.entrySet()) {
			buckets.get(entry.getValue()).add(entry.getKey());
		}

		int pos = max;
		int[] answer = new int[k];
		int i = 0;
		while (pos >= 0) {
			for (int value : buckets.get(pos)) {
				answer[i++] = value;
				if (i == k) {
					return answer;
				}
			}
			pos--;
		}

		return answer;
