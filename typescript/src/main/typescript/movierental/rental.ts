import { Movie, NewReleaseMovie } from "./movie";

export class Rental {

    private movie: Movie;
    private daysRented: number;

    public constructor(movie: Movie, daysRented: number) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public getDaysRented(): number {
        return this.daysRented;
    }

    public getMovie(): Movie {
        return this.movie;
    }

    public calculateRentalPrice(): number {
        return this.movie.calculateRentalPrice(this.daysRented);
    }

    public getRenterPoint(): number {
        if ((this.movie instanceof NewReleaseMovie) && this.daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
