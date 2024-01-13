<script lang="ts">
export default {
  data(): {
    tab: "newgame" | "extistinggame" | "game_created";
    playernames: Array<string>;
    newPlayername: string;
    joinplayernames: Array<string>;
    joinGameCode: string;
    joinPlayername: string;
    gamecreatedID: string;
    rules: {
      required: (v: string) => boolean | string;
      noPlayernameDoubled: (v: string) => boolean | string;
      playernamelenght: (v: string) => boolean | string;
    };
  } {
    return {
      tab: "newgame" as "newgame" | "extistinggame" | "game_created",
      playernames: Array<string>(),
      newPlayername: "",
      joinplayernames: Array<string>(),
      joinGameCode: "",
      joinPlayername: "",
      gamecreatedID: "",
      rules: {
        required: (v: string) => !!v || "This field is required",
        noPlayernameDoubled: (v: string) => {
          let playernames = this.playernames as unknown as Array<string>;
          if (playernames.includes(v)) {
            return "Playername already exists";
          }
          return true;
        },
        playernamelenght: (v: string) => {
          if (v.length === 0) {
            return true;
          }
          if (v.length < 3) {
            return "Playername must be at least 3 characters long";
          }
          if (v.length > 20) {
            return "Playername must be at most 20 characters long";
          }
          return true;
        },
      },
    };
  },
  methods: {
    addPlayername: (): void => {
      // ? dont ask why `this` is undefined
      // @ts-ignore
      if (this.newPlayername === "") return;
      // @ts-ignore
      if (this.playernames.includes(this.newPlayername)) return;
      // @ts-ignore
      if (this.newPlayername.length < 3) return;
      // @ts-ignore
      if (this.newPlayername.length > 20) return;
      // @ts-ignore
      this.playernames.push(this.newPlayername);
      // @ts-ignore
      this.newPlayername = "";
    },
    loadPlayernames: (): void => {},
    joinGame: (): void => {}
  },
};
</script>

<template>
  <div class="wrapper">
    <VCard>
      <VTabs align-tabs="center" fixed-tabs v-model="tab">
        <VTab value="newgame">New</VTab>
        <VTab value="extistinggame">Existing</VTab>
      </VTabs>

      <VWindow v-model="tab">
        <VWindowItem value="newgame">
          <VCardTitle>New Game</VCardTitle>
          <VCardSubtitle>
            Create a new game and invite your friends.
          </VCardSubtitle>
          <VCardItem>
            <VTextField
              @change="addPlayername"
              v-model="newPlayername"
              label="New Player"
              hint="Add a new players name"
              :rules="[rules.noPlayernameDoubled, rules.playernamelenght]"
            />
            <VList>
              <VListItem
                variant="tonal"
                rounded
                :key="player"
                v-for="player in playernames"
              >
                <VListItemTitle
                  style="display: flex; align-items: center, flex-direction: row; gap: 10px;"
                >
                  <VIcon
                    title="remove player"
                    icon="mdi-account-remove-outline"
                    @click="playernames.splice(playernames.indexOf(player), 1)"
                  />
                  {{ player }}
                </VListItemTitle>
              </VListItem>
            </VList>
          </VCardItem>
          <VCardActions>
            <VBtn style="width: 100%" variant="tonal">Create</VBtn>
          </VCardActions>
        </VWindowItem>

        <VWindowItem value="game_created">
          <VCardTitle>Start Game</VCardTitle>
          <VCardSubtitle> Share the game code with you friends. </VCardSubtitle>
          <VCardItem>
            <VTextField
              :value="gamecreatedID"
              :v-model="gamecreatedID"
              label="Game Codֻe"
              hint="This is your game code to share with your friends"
              readonly
            />
          </VCardItem>
          <VCardActions>
            <VBtn style="width: 100%" variant="tonal">Start</VBtn>
          </VCardActions>
        </VWindowItem>

        <VWindowItem value="extistinggame">
          <VCardTitle>Existing Game</VCardTitle>
          <VCardSubtitle>
            Join an existing game and play with your friends.
          </VCardSubtitle>
          <VForm @submit.prevent="joinGame">
            <VCardItem>
              <VTextField
                label="Game Code"
                hint="Share this code with your friends"
                placeholder="123456"
                v-model="joinGameCode"
                :rules="[rules.required]"
                @input="loadPlayernames"
              />
              <VSelect
                label="Player"
                placeholder="Select a player"
                :items="joinplayernames"
                :rules="[rules.required]"
                v-model="joinPlayername"
              />
            </VCardItem>
            <VCardActions>
              <VBtn style="width: 100%" variant="tonal">Join</VBtn>
            </VCardActions>
          </VForm>
        </VWindowItem>
      </VWindow>
    </VCard>
  </div>
</template>

<style scoped>
.wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.wrapper > .v-card {
  width: min(100%, 400px);
}

.v-list {
  overflow: visible;
}

.v-list .v-list-item {
  margin-bottom: 5px;
}

.v-list .v-list-item:last-child {
  margin-bottom: -10px;
}
</style>
