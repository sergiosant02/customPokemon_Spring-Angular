import { Type } from "@angular/compiler";
import { Ability } from "./ability";
import { GameIndex } from "./game-index";
import { Move } from "./move";
import { Specie } from "./specie";
import { Sprit } from "./spirit";
import { Stat } from "./stat";

export interface Pokemon {
    abilities:                Ability[];
    base_experience:          number;
    forms:                    Specie[];
    game_indices:             GameIndex[];
    height:                   number;
    held_items:               any[];
    id:                       number;
    is_default:               boolean;
    location_area_encounters: string;
    moves:                    Move[];
    name:                     string;
    order:                    number;
    past_types:               any[];
    species:                  Specie;
    sprites:                  Sprit;
    stats:                    Stat[];
    types:                    Type[];
    weight:                   number;
}
