package com.example.springdatahltv.init;

import com.example.springdatahltv.dtos.MatchDto;
import com.example.springdatahltv.dtos.PlayerDto;
import com.example.springdatahltv.dtos.TeamDto;
import com.example.springdatahltv.dtos.TeamsMatchesDto;
import com.example.springdatahltv.services.MatchService;
import com.example.springdatahltv.services.PlayerService;
import com.example.springdatahltv.services.TeamService;
import com.example.springdatahltv.services.TeamsMatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    private final TeamService teamService;
    @Autowired
    private final PlayerService playerService;
    @Autowired
    private final MatchService matchService;
    @Autowired
    private final TeamsMatchesService teamsMatchesService;

    public CommandLineRunnerImpl(TeamService teamService,
                                 PlayerService playerService,
                                 MatchService matchService,
                                 TeamsMatchesService teamsMatchesService) {
        this.teamService = teamService;
        this.playerService = playerService;
        this.matchService = matchService;
        this.teamsMatchesService = teamsMatchesService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        printMatchesByScore("16:14");
        printMatchesByTeamName("NAVI");
        printMatchesByNickname("s1mple");
    }

    private void printMatchesByNickname(String nickname) {
        matchService.findMatchesByNickname(nickname).forEach(System.out::println);
    }
    private void printMatchesByScore(String score) {
        matchService.findMatchesByScore(score).forEach(System.out::println);
    }
    private void printMatchesByTeamName(String name) {
        matchService.findMatchesByTeamName(name).forEach(System.out::println);
    }

    private void seedData() throws IOException {

        TeamDto team1 = new TeamDto(1, "NAVI", 6, "B1ad3");
        TeamDto team2 = new TeamDto(2, "Vitality", 2, "zonic");
        TeamDto team3 = new TeamDto(3, "Heroic", 1, "Xizt");
        teamService.create(team1); teamService.create(team2); teamService.create(team3);

        PlayerDto player1 = new PlayerDto("s1mple", "Alexandr Kostylev", 23, "sniper", "Ukraine");
        PlayerDto player2 = new PlayerDto("ZyWoo", "Mathieu Herbaut", 23, "rifler", "France");
        PlayerDto player3 = new PlayerDto("cadiaN", "Casper Muller", 27, "captain", "Denmark");

        player1.setTeam_id(1);
        player2.setTeam_id(2);
        player3.setTeam_id(3);

        Set<PlayerDto> playersOfTeam1 = new HashSet<>();
        playersOfTeam1.add(playerService.add(player1));
        playersOfTeam1.add(playerService.add(player2));
        playersOfTeam1.add(playerService.add(player3));

        MatchDto match1 = new MatchDto(1, new Date(2020,2,20),
                "BLAST SPRING FINALS 2020", "16:14", "NAVI", "Astralis");
        MatchDto match2 = new MatchDto(2, new Date(2021,6,10),
                "ESL ONE COLOGNE 2021", "16:13", "Vitality", "Heroic");
        MatchDto match3 = new MatchDto(3, new Date(2021,9,18),
                "PGL STOCKHOLM MAJOR 2021", "2:0", "NAVI", "G2");
        matchService.add(match1); matchService.add(match2); matchService.add(match3);


        TeamsMatchesDto teamMatches1 = new TeamsMatchesDto(team1.getId(), match1.getId());
        TeamsMatchesDto teamMatches2 = new TeamsMatchesDto(team2.getId(), match2.getId());
        TeamsMatchesDto teamMatches3 = new TeamsMatchesDto(team1.getId(), match3.getId());
        teamsMatchesService.add(teamMatches1);
        teamsMatchesService.add(teamMatches2);
        teamsMatchesService.add(teamMatches3);
    }
}
