package level2;

public class level2_skillTree {
    public static void main(String[] args) {
        new level2_skillTree().solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            String skills = skill_trees[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < skills.length(); j++) {
                if (skill.contains(skills.substring(j, j + 1))) {
                    sb.append(skills.charAt(j));
                }
            }

            boolean possibleSkillTree = true;
            for (int k = 0; k < sb.toString().length(); k++) {
                if (sb.charAt(k) != skill.charAt(k)) {
                    possibleSkillTree = false;
                }
            }


            if (possibleSkillTree) {
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
