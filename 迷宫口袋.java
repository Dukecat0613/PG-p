public static List<String> findPath(int[][] nums) {
    	int m = nums.length;
    	int n = nums[0].length;
    	int count = 0;
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (nums[i][j] == 1) {
    				count++; 
    			}
    		}
    	}
    	List<List<String>> res = new ArrayList<>();
    	Map<String, String> map = new HashMap<>();
    	map.put("Up", "Down");
    	map.put("Down", "Up");
    	map.put("Left", "Right");
    	map.put("Right", "Left");
    	pathDfs(nums, 1, 0, new boolean[m][n], 1, new ArrayList<>(), res, count, map);
      if (res.size() == 0) {
        return null;
      }
    	return res.get(0);
    }
    public static void pathDfs(int[][] nums, int i , int j, boolean[][] visited, int count, List<String> path,
    		List<List<String>> res, int target, Map<String, String> map) {
    	if (count == target) {
    		res.add(new ArrayList<>(path));
    		return;
    	}
    	visited[i][j] = true;
    	boolean one = isValid(i - 1, j, nums, visited);
    	boolean two = isValid(i + 1, j, nums, visited);
    	boolean three = isValid(i, j - 1, nums, visited);
    	boolean four = isValid(i, j + 1, nums, visited);
    	if (one) {
    		path.add("Up");
    		pathDfs(nums, i - 1, j, visited, count += 1, path, res, target, map);
    	}
    	if (two) {
    		path.add("Down");
    		pathDfs(nums, i + 1, j, visited, count += 1, path, res, target, map);
    	}
    	if (three) {
    		path.add("Left");
    		pathDfs(nums, i, j - 1, visited, count += 1, path, res, target, map);
    	}
    	if (four) {
    		path.add("Right");
    		pathDfs(nums, i, j + 1, visited, count += 1, path, res, target, map);
    	}
    	if (!(one || two || three || four)) {
    		if (path.size() >= 1) {
    			path.add(map.get(path.get(path.size() - 1)));
    		}
    	}
    	
    }
