package br.com.devotaku.comicdomain.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Genre {

    ACTION("Plays out mainly through a clash of physical forces. Frequently these stories have fast cuts, tough characters making quick decisions and usually a beautiful girl nearby. Anything quick and most likely a thin storyline."),
    ADVENTURE("Exploring new places, environments or situations. This is often associated with people on long journeys to places far away encountering amazing things, usually not in an epic but in a rather gripping and interesting way."),
    CARS("Anime whose central theme revolves around cars and probably car races. A single character's obsession for cars does not mean that it should belong to this genre. Most of these stories also are in the action genre."),
    COMEDY("Multiple characters and/or events causing hilarious results. These stories are built upon funny characters, situations and events."),
    DEMENTIA("Anime that have mind-twisting plots."),
    DEMONS("Anime that are set in a world where demons and other dark creatures play a significant role - the main character may even be one."),
    DRAMA("Anime that often show life or characters through conflict and emotions. In general, the different parts of the story tend to form a whole that is greater than the sum of the parts. In other words, the story has a message that is bigger than just the story line itself."),
    ECCHI("Anime that contain a lot of sexual innuendo. The translation of this letter (Ecchi is the letter 'H' in Japanese) is pervert. Ecchi is about panties (pantsu) and bra/breast showing, situations with \"sudden nudity\" and of course, subtle hints or sexual thoughts. Ecchi does not describe actual sex acts or show any intimate body parts except for bare breasts and buttocks. Ecchi is almost always used for humor."),
    FANTASY(" Anime that are set in a mythical world quite different from modern-day Earth. Frequently this world has magic and/or mythical creatures such as dragons and unicorns. These stories are sometimes based on real world legends and myths. Frequently fantasies describe tales featuring magic, brave knights, damsels in distress, and/or quests."),
    GAME("Anime whose central theme is based on a non-violent, non-sports game, like go, chess, trading card games or computer/video games."),
    HAREM("Anime that involves one lead male character and many cute/pretty female support characters. Typically, the male lead ends up living with many female support characters within the same household. The lead male typically represents the average guy who is shy, awkward, and girlfriendless. While each female character surround the lead male possesses distinct physical and personality traits, those traits nevertheless represent different stereotypical roles that play on popular Japanese fetishes; i.e. the librarian/genius, tomboy, little sister, and older woman. Some anime that are under the harem genre are: Love Hina, Girls Bravo, Maburaho, and Sister Princess."),
    HISTORICAL("Anime whose setting is in the past. Frequently these follow historical tales, sagas or facts."),
    HORROR("Anime whose focus is to scare the audience."),
    KID("Anime whose target audience is children. This does not necessarily mean that the character(s) are children or that an anime whose main character(s) are children is appropriate for this genre."),
    MAGIC("Anime whose central theme revolves around magic. Things that are \"out of this world\" happen - incidents that cannot be explained by the laws of nature or science. Usually wizards/witches indicate that it is of the \"Magic\" type. This is a sub-genre of fantasy."),
    MARTIAL_ARTS("Anime whose central theme revolves around martial arts. This includes all hand-to-hand fighting styles, including Karate, Tae-Kwon-Do and even Boxing. Weapons use, like Nunchaku and Shuriken are also indications of this genre. This is a sub-genre of action."),
    MECHA("Anime whose central theme involves mechanical things. This genre is mainly used to point out when there are giant robots. Human size androids are in general not considered \"Mecha\" but \"SciFi\"."),
    MILITARY("An anime series/movie that has a heavy militaristic feel behind it."),
    MUSIC("Anime whose central theme revolves around singers/idols or people playing instruments. This category is not intended for finding AMVs (Animated Music Videos)."),
    MYSTERY("Anime where characters reveal secrets that may lead a solution for a great mystery. This is not necessarily solving a crime, but can be a realization after a quest."),
    PARODY("Anime that imitate other stories (can be from TV, film, books, historical events, ...) for comic effect by exaggerating the style and changing the content of the original. Also known as spoofs. This is a sub-genre of comedy."),
    POLICE("Anime where a police organization are a major part of the story."),
    PSYCHOLOGICAL("Often when two or more characters prey each others' minds, either by playing deceptive games with the other or by merely trying to demolish the other's mental state."),
    ROMANCE("Anime whose story is about two people who each want [sometimes unconciously] to win or keep the love of the other. This kind of anime might also fall in the \"Ecchi\" category, while \"Romance\" and \"Hentai\" generally contradict each other."),
    SAMURAI("Anime whose main character(s) are samurai, the old, but not forgotten, warrior cast of medieval Japan."),
    SCHOOL("Anime which are mainly set in a school environment."),
    SCI_FI("Anime where the setting is based on the technology and tools of a scientifically imaginable world. The majority of technologies presented are not available in the present day and therefore the Science is Fiction. This incorporates any possible place (planets, space, underwater, you value it)."),
    SEINEN("No description available."),
    SHOUJO("Anime that are targeted towards the \"young girl\" market. Usually the story is from the point of view of a girl and deals with romance, drama or magic."),
    SHOUJO_AI("Anime whose central theme is about a relationship (or strong affection, not usually sexual) between two girls or women. Shoujo Ai literally means \"girl love\"."),
    SHOUNEN("Anime that are targeted towards the \"young boy\" market. The usual topics for this involve fighting, friendship and sometimes super powers."),
    SHOUNEN_AI("Anime whose central theme is about a relationship (or strong affection, not usually sexual) between two boys or men. Shounen Ai literally means \"boy love\", but could be expressed as \"male bonding\"."),
    SLICE_OF_LIFE("Anime with no clear central plot. This type of anime tends to be naturalistic and mainly focuses around the main characters and their everyday lives. Often there will be some philosophical perspectives regarding love, relationships, life etc. tied into the anime. The overall typical moods for this type of anime are cheery and carefree, in other words, it is your \"feel-good\" kind of anime. Some anime that are under the slice of life genre are: Ichigo Mashimaro, Fruits Basket, Aria the Natural, Honey and Clover, and Piano."),
    SPACE("Anime whose setting is in outer space, not on another planet, nor in another dimension, but space. This is a sub-genre of scifi."),
    SPORTS("Anime whose central theme revolves around sports, examples are tennis, boxing and basketball."),
    SUPER_POWER("Anime whose main character(s) have powers beyond normal humans. Often it looks like magic, but can't really be considered magic; usually ki-attacks, flying or superhuman strength."),
    SUPERNATURAL("Anime of the paranormal stature. Demons, vampires, ghosts, undead, etc."),
    THRILLER("No description available."),
    VAMPIRE("Anime whose main character(s) are vampires or at least vampires play a significant role in the story."),
    YAIO("Anime whose central theme is a sexual relationship between two boys or men. This implies Hentai."),
    YURI("Anime whose central theme is a sexual relationship between two girls or women. This implies Hentai.");

    private final String description;

}
