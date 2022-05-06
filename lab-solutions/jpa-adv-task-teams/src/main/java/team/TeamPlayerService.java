package team;

public class TeamPlayerService {

    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;

    public TeamPlayerService(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    public void transferPlayer(long teamId, long playerId) {
        Team team = teamRepository.findTeamById(teamId);
        Player player = playerRepository.findById(playerId);

        if (player.getTeam() == null) {
            playerRepository.updatePlayerTeam(playerId, teamId);
        } else if (hasEnoughtBudgetFor(team, player)) {
            Team originalTeam = player.getTeam();
            if (originalTeam != null) {
                teamRepository.updateBudget(originalTeam.getId(), originalTeam.getBudget() + player.getValue());
            }
            playerRepository.updatePlayerTeam(playerId, teamId);
            teamRepository.updateBudget(teamId, team.getBudget() - player.getValue());
        } else {
            throw new NotEnoughBudgetException("Cannot buy Player!");
        }

    }

    private boolean hasEnoughtBudgetFor(Team team, Player player) {
        return player.getValue()<(team.getBudget()*20.0)/100.0;
    }

}
